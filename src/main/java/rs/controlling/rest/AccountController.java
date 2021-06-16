/**
 * 
 */
package rs.controlling.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import rs.controlling.data.account.Account;
import rs.controlling.data.account.AccountSubType;
import rs.controlling.data.account.AccountType;
import rs.controlling.service.AccountService;

/**
 * The REST controller
 * @author ralph
 *
 */
@RestController
@RequestMapping(path = "/accounts")
public class AccountController {

	@Autowired
	private AccountService accounts;

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
	public List<Account> list(@RequestParam(name="type",required=false) String type, @RequestParam(name="subtype",required=false) String subType) {
		AccountType    t1 = (type != null)    ? AccountType.get(type)       : null;
		AccountSubType t2 = (subType != null) ? AccountSubType.get(subType) : null;	
		System.out.println(type+"="+t1+" : "+subType+"="+t2);
		return accounts.findBy(t1, t2);
	}
	
	@PostMapping
	public Account newAccount(@RequestBody Account newAccount) {
		return accounts.create(newAccount);
	}

	@GetMapping("/{number}")
	public Account get(@PathVariable String number) {
		return accounts.get(number);
	}

	@PutMapping("/{number}")
	public Account update(@RequestBody Account newAccount, @PathVariable String number) {
		Account account = accounts.get(number);
		account.setName(newAccount.getName());
		account.setDescription(newAccount.getDescription());
		return accounts.update(account);
	}

	@DeleteMapping("/{number}")
	public void delete(@PathVariable String number) {
		Account account = accounts.get(number);
		accounts.delete(account);
	}
	
}
