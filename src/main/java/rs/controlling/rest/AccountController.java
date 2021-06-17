/**
 * 
 */
package rs.controlling.rest;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.http.ResponseEntity;
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
import rs.controlling.rest.util.AccountModelAssembler;
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

	@Autowired
	private AccountModelAssembler assembler;
	
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
	public CollectionModel<EntityModel<Account>> list(@RequestParam(name="type",required=false) String type, @RequestParam(name="subtype",required=false) String subType) {
		AccountType    t1 = (type != null)    ? AccountType.get(type)       : null;
		AccountSubType t2 = (subType != null) ? AccountSubType.get(subType) : null;	
		List<EntityModel<Account>> rc =  accounts.findBy(t1, t2).stream().map(assembler::toModel)
		      .collect(Collectors.toList());

		  return CollectionModel.of(rc, linkTo(methodOn(AccountController.class).list(type, subType)).withSelfRel());
	}
	
	@PostMapping
	public ResponseEntity<?> newAccount(@RequestBody Account newAccount) {
		Account account = accounts.create(newAccount);
		EntityModel<Account> entityModel = assembler.toModel(account);
		return ResponseEntity
			      .created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri())
			      .body(entityModel);
	}

	@GetMapping("/{number}")
	public EntityModel<Account> get(@PathVariable String number) {
		Account account = accounts.get(number);
		return assembler.toModel(account);
	}

	@PutMapping("/{number}")
	public EntityModel<Account> update(@RequestBody Account newAccount, @PathVariable String number) {
		Account account = accounts.get(number);
		account.setName(newAccount.getName());
		account.setDescription(newAccount.getDescription());
		account = accounts.update(account);
		return assembler.toModel(account);
	}

	@DeleteMapping("/{number}")
	public ResponseEntity<?> delete(@PathVariable String number) {
		Account account = accounts.get(number);
		accounts.delete(account);
		return ResponseEntity.noContent().build();
	}
	
}
