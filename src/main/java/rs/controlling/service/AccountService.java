/**
 * 
 */
package rs.controlling.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Component;

import rs.controlling.data.account.Account;
import rs.controlling.data.account.AccountRepository;
import rs.controlling.data.account.AccountSubType;
import rs.controlling.data.account.AccountType;
import rs.controlling.data.ledger.AccountPosting;
import rs.controlling.data.ledger.AccountPostingRepository;
import rs.controlling.exception.AccountExistsException;
import rs.controlling.exception.AccountNotEmptyException;
import rs.controlling.exception.AccountNotFoundException;
import rs.controlling.exception.IncompleteRequestException;

/**
 * Service for accounts.
 * @author ralph
 *
 */
@Component
public class AccountService {

	@Autowired
	private AccountRepository accounts;
	@Autowired
	private AccountPostingRepository postings;

	/**
	 * Constructor.
	 */
	public AccountService() {
	}

	public List<Account> findBy(AccountType type, AccountSubType subType) {
		if (type != null) {
			if (subType != null) return accounts.findByAccountTypeAndAccountSubType(type, subType);
			return accounts.findByAccountType(type);
		} else if (subType != null) {
			return accounts.findByAccountSubType(subType);
		}
		return accounts.findAll();
	}
	
	public Account get(String number) {
		if (number == null) {
			throw new IncompleteRequestException("accountNumber", null);
		}
		Account account = accounts.findByAccountNumber(number);
		if (account == null) throw new AccountNotFoundException(number);
		return account;
	}

	public Account create(Account newAccount) {
		newAccount.setBalance(BigDecimal.ZERO);
		checkComplete(newAccount);
		if (accounts.findByAccountNumber(newAccount.getAccountNumber()) != null) {
			throw new AccountExistsException(newAccount.getAccountNumber());
		}
		return accounts.save(newAccount);
	}
	
	public Account update(Account account) {
		return accounts.save(account);
	}

	public void delete(Account account) {
		if (account.isActive() && BigDecimal.ZERO.equals(account.getBalance())) {
			if (postings.count(Example.of(AccountPosting.from(account))) > 0) {
				account.setActive(false);
				accounts.save(account);
			} else {
				accounts.delete(account);
			}
		}
		throw new AccountNotEmptyException(account.getAccountNumber(), account.getBalance());
	}
	
	protected void checkComplete(Account account) {
		if (account.getAccountNumber() == null) {
			throw new IncompleteRequestException("accountNumber", null);
		}
		if (account.getAccountType() == null) {
			throw new IncompleteRequestException("accountType", null);
		}
		if (account.getAccountSubType() == null) {
			throw new IncompleteRequestException("accountSubType", null);
		}
		if (account.getName() == null) {
			throw new IncompleteRequestException("name", null);
		}
		if (account.isActive() == null) {
			account.setActive(Boolean.TRUE);
		}
	}

}
