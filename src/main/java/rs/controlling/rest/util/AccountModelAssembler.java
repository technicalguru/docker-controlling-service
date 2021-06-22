/**
 * 
 */
package rs.controlling.rest.util;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import rs.controlling.data.account.Account;
import rs.controlling.rest.AccountController;

/**
 * Ease the additional link creation.
 * @author ralph
 *
 */
@Component
public class AccountModelAssembler implements RepresentationModelAssembler<Account, EntityModel<Account>> {

	@Override
	public EntityModel<Account> toModel(Account account) {
		EntityModel<Account> model = EntityModel.of(account, //
			      linkTo(methodOn(AccountController.class).get(account.getAccountNumber())).withSelfRel(),
			      linkTo(methodOn(AccountController.class).list(null, null)).withRel("accounts"));
		 
		// We could do (even under certain conditions of account)
		// model.add(linkTo(methodOn(AccountController.class).close(account.getAccountNumber())).withRel("close"));
		
		return model;
	}


}
