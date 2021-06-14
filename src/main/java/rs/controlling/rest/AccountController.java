/**
 * 
 */
package rs.controlling.rest;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rs.controlling.data.account.Account;
import rs.controlling.data.account.AccountNotFoundException;
import rs.controlling.data.account.AccountRepository;
import rs.controlling.data.ledger.AccountPosting;
import rs.controlling.data.ledger.AccountPostingRepository;

/**
 * The REST controller
 * @author ralph
 *
 */
@RestController
@RequestMapping(path = "/accounts")
public class AccountController {

	@Autowired
	private AccountRepository repository;
	@Autowired
	private AccountPostingRepository postingsRepository;

	/**
	 * Constructor.
	 */
	public AccountController() {
	}

	/**
	 * List all accounts.
	 * @return
	 */
	@GetMapping
	public List<Account> list() {
		return repository.findAll();
	}
	
	@PostMapping
	public Account newAccount(@RequestBody Account newAccount) {
		return repository.save(newAccount);
	}

	@GetMapping("/{number}")
	public Account get(@PathVariable String number) {
		Account account = repository.findByAccountNumber(number);
		if (account == null) throw new AccountNotFoundException(number);
		return account;
	}

	@PutMapping("/{number}")
	public Account update(@RequestBody Account newAccount, @PathVariable String number) {
		Account account = repository.findByAccountNumber(number);
		if (account == null) throw new AccountNotFoundException(number);
		account.setName(newAccount.getName());
		account.setDescription(newAccount.getDescription());
		return repository.save(account);
	}

	@DeleteMapping("/{number}")
	public void delete(@PathVariable String number) {
		Account account = repository.findByAccountNumber(number);
		if (account == null) throw new AccountNotFoundException(number);
		if (account.isActive() && BigDecimal.ZERO.equals(account.getBalance())) {
			if (postingsRepository.count(Example.of(AccountPosting.from(account))) > 0) {
				account.setActive(false);
				repository.save(account);
			} else {
				repository.delete(account);
			}
		}
	}
}
