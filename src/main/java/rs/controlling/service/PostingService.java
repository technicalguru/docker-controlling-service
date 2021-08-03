/**
 * 
 */
package rs.controlling.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import rs.controlling.data.account.Account;
import rs.controlling.data.account.AccountRepository;
import rs.controlling.data.account.AccountType;
import rs.controlling.data.ledger.AccountPosting;
import rs.controlling.data.ledger.AccountPostingRepository;
import rs.controlling.data.ledger.AccountPostingType;
import rs.controlling.data.ledger.Posting;
import rs.controlling.data.ledger.PostingRepository;
import rs.controlling.data.ledger.PostingType;
import rs.controlling.exception.AccountNotFoundException;
import rs.controlling.exception.IncompleteRequestException;
import rs.controlling.exception.InvalidAccountException;
import rs.controlling.exception.InvalidAmountException;
import rs.controlling.exception.PostingAlreadyExistsException;
import rs.controlling.exception.PostingNotFoundException;

/**
 * Handles entry of new postings.
 * @author ralph
 *
 */
@Component
@Transactional
public class PostingService {

	@Autowired
	private PostingRepository postings;
	@Autowired
	private AccountPostingRepository details;
	@Autowired
	private AccountRepository accounts;

	/**
	 * Constructor.
	 */
	public PostingService() {
	}

	public List<Posting> list(String accountNumber, Pageable pageable) {
		Account account = accounts.findByAccountNumber(accountNumber);
		List<AccountPosting> ap = details.findByAccount(account);
		return postings.findByAccountPostingsIn(ap, pageable);
	}
	
	public List<Posting> list(String source, String reference, Pageable pageable) {
		Posting p = new Posting();
		p.setSource(source);
		p.setSourceReference(reference);
		return postings.findAll(Example.of(p), pageable).toList();
	}

	public Posting create(PostingRequest posting) {
		// Check completeness
		checkComplete(posting);
		checkPostingExists(posting);
		checkAmount(posting.getAmount());
		Account account1 = checkAccountExists(posting.getAccountNumber1());
		Account account2 = checkAccountExists(posting.getAccountNumber2());
		if (account1.equals(account2)) {
			throw new InvalidAccountException(account1.getAccountNumber());
		}
		checkAccountTypes(posting.getPostingType(), account1, account2);

		// Create the posting and the details
		Posting rc = new Posting(nextPostingNumber(), posting.getPostingType(), posting.getSource(), posting.getSourceReference(), posting.getCreationTime(), posting.getDescription());
		rc = postings.save(rc);
		createAccountDetails(true,  posting, rc, account1);
		createAccountDetails(false, posting, rc, account2);

		return rc;
	}

	public Posting findById(String number) {
		Posting rc = postings.findByPostingNumber(number);
		if (rc == null) throw new PostingNotFoundException(number);
		return rc;
	}

	protected AccountPosting createAccountDetails(boolean isFrom, PostingRequest request, Posting posting, Account account) {
		AccountPosting rc = null;
		// Find out how to create
		switch (posting.getPostingType()) {
		case ASSET_SWAP:
		case LIABILITY_SWAP:
			rc = new AccountPosting(posting, account, isFrom ? AccountPostingType.DEBIT : AccountPostingType.CREDIT, request.getAmount());
			break;
		case EXTENSION:
			rc = new AccountPosting(posting, account, AccountPostingType.CREDIT, request.getAmount());
			break;
		case REDUCTION:
			rc = new AccountPosting(posting, account, AccountPostingType.DEBIT, request.getAmount());
			break;
		}
		rc = details.save(rc);

		// Update the posting
		posting = postings.save(posting);

		// Update the account
		if (rc.getPostingType().equals(AccountPostingType.CREDIT)) {
			account.credit(rc.getAmount());
		} else {
			account.debit(rc.getAmount());
		}
		accounts.save(account);

		return rc;
	};

	protected void checkComplete(PostingRequest posting) {
		if (posting.getPostingType() == null) {
			throw new IncompleteRequestException("postingType", posting.getPostingType());
		}
		if (posting.getAccountNumber1() == null) {
			throw new IncompleteRequestException("accountNumber1", posting.getAccountNumber1());
		}
		if (posting.getAccountNumber2() == null) {
			throw new IncompleteRequestException("accountNumber2", posting.getAccountNumber2());
		}
		if (posting.getSource() == null) {
			throw new IncompleteRequestException("source", posting.getSource());
		}
		if (posting.getSourceReference() == null) {
			throw new IncompleteRequestException("sourceReference", posting.getSourceReference());
		}
	}

	protected void checkPostingExists(PostingRequest posting) {
		// Check source and source Reference (must not exist)
		BigDecimal  amount = posting.getAmount();
		String      n1     = posting.getAccountNumber1();
		String      n2     = posting.getAccountNumber2();
		PostingType type   = posting.getPostingType();

		// Search for posting with same reference, posting type, accounts and amount
		for (Posting p : postings.findBySourceAndSourceReference(posting.getSource(), posting.getSourceReference())) {
			if (p.getPostingType().equals(type)) {
				int cnt = 0;
				for (AccountPosting ap : p.getAccountPostings()) {
					if (ap.getAmount().compareTo(amount) == 0) {
						String n = ap.getAccount().getAccountNumber();
						if (n.equals(n1)) cnt++;
						else if (n.equals(n2)) cnt++;
					}
				}
				if (cnt > 1) {
					throw new PostingAlreadyExistsException(posting.getSource(), posting.getSourceReference(), posting.getAmount(), posting.getAccountNumber1(), posting.getAccountNumber2());
				}
			}
		}
	}

	protected void checkAmount(BigDecimal amount) {
		// Amount must be > 0
		if (amount == null) {
			throw new IncompleteRequestException("amount", null);
		}
		if (amount.compareTo(BigDecimal.ZERO) <= 0) {
			throw new InvalidAmountException(amount);
		}
	}

	protected Account checkAccountExists(String accountNumber) {
		Account account = accounts.findByAccountNumber(accountNumber);
		if (account == null) {
			throw new AccountNotFoundException(accountNumber);
		}
		return account;
	}

	protected void checkAccountTypes(PostingType postingType, Account account1, Account account2) {
		// Depending on type: account aktiva/passiva type
		switch (postingType) {
		case EXTENSION:
		case REDUCTION:
			// Accounts must be ASSETS and LIABILITIES
			checkAccountType(account1, AccountType.ASSETS);
			checkAccountType(account2, AccountType.LIABILITIES);
			break;
		case ASSET_SWAP:
			// Accounts must be ASSETS
			checkAccountType(account1, AccountType.ASSETS);
			checkAccountType(account2, AccountType.ASSETS);
			break;
		case LIABILITY_SWAP:
			// Accounts must be LIABILITIES
			checkAccountType(account1, AccountType.LIABILITIES);
			checkAccountType(account2, AccountType.LIABILITIES);
			break;
		}
	}

	protected void checkAccountType(Account account, AccountType expected) {
		if (!account.getAccountType().equals(expected)) {
			throw new InvalidAccountException(account.getAccountNumber(), account.getAccountType(), expected);
		}
	}

	protected String nextPostingNumber(String...names) {
		String rc = null;
		do {
			rc = UUID.randomUUID().toString();
			Posting posting = postings.findByPostingNumber(rc);
			if (posting != null) rc = null;
		} while (rc == null);
		return rc;
	}
}
