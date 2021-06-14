/**
 * 
 */
package rs.controlling.data.account;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The REST controller
 * @author ralph
 *
 */
@RestController
@RequestMapping(path = "/accounts")
public class AccountController {

	private final AccountRepository repository;

	/**
	 * Constructor.
	 */
	public AccountController(AccountRepository repository) {
		this.repository = repository;
	}

	/**
	 * List all accounts.
	 * @return
	 */
	// Aggregate root
	// tag::get-aggregate-root[]
	@GetMapping
	public List<Account> list() {
		return repository.findAll();
	}
	// end::get-aggregate-root[]
	
	@PostMapping
	public Account newAccount(@RequestBody Account newAccount) {
		return repository.save(newAccount);
	}

	// TODO never on uid, better on number
	@GetMapping("/{id}")
	public Account get(@PathVariable Long id) {
		return repository.findById(id)
				.orElseThrow(() -> new AccountNotFoundException(id));
	}

	// TODO never on uid, better on number
	@PutMapping("/{id}")
	public Account update(@RequestBody Account newAccount, @PathVariable Long id) {

		return repository.findById(id)
				.map(account -> {
					account.setName(newAccount.getName());
					account.setDescription(newAccount.getDescription());
					return repository.save(account);
				})
				.orElseThrow(() -> new AccountNotFoundException(id));
	}

	// TODO never on uid, better on number
	// TODO deactivate account / delete when no bookings only
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		repository.deleteById(id);
	}
}
