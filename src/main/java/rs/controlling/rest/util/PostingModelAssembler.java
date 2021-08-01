/**
 * 
 */
package rs.controlling.rest.util;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import rs.controlling.data.ledger.Posting;
import rs.controlling.rest.PostingController;

/**
 * Ease the additional link creation.
 * @author ralph
 *
 */
@Component
public class PostingModelAssembler implements RepresentationModelAssembler<Posting, EntityModel<Posting>> {

	@Override
	public EntityModel<Posting> toModel(Posting account) {
		EntityModel<Posting> model = EntityModel.of(account, //
			      linkTo(methodOn(PostingController.class).get(account.getPostingNumber())).withSelfRel(),
			      linkTo(methodOn(PostingController.class).list(null, null, null)).withRel("postings"));
		 
		// We could do (even under certain conditions of account)
		// model.add(linkTo(methodOn(PostingController.class).close(account.getPostingNumber())).withRel("close"));
		
		return model;
	}


}
