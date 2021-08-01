/**
 * 
 */
package rs.controlling.rest;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import rs.controlling.data.ledger.Posting;
import rs.controlling.rest.util.PostingModelAssembler;
import rs.controlling.rest.util.RestUtils;
import rs.controlling.service.PostingRequest;
import rs.controlling.service.PostingService;

/**
 * The REST controller
 * @author ralph
 *
 */
@RestController
@RequestMapping(path = "/postings")
@Transactional(rollbackFor = Exception.class)
public class PostingController {

	@Autowired
	private PostingService service;

	@Autowired
	private PostingModelAssembler assembler;
	
	/**
	 * Constructor.
	 */
	public PostingController() {
	}

	/**
	 * List all accounts.
	 * @return
	 */
	@GetMapping
	public CollectionModel<EntityModel<Posting>> list(
			@RequestParam(name="account",required=false) String accountNumber, 
			@RequestParam(name="source",required=false)  String source, 
			@RequestParam(name="ref",required=false)     String reference,
			@RequestParam(name="page",required=false)    Integer page,
			@RequestParam(name="size",required=false)    Integer size,
			@RequestParam(name="sort",required=false)    String sort) {
		List<Posting> list = null;
		
		if (sort == null) sort = "creationTime:asc";
		Pageable pageable = RestUtils.createPageable(page, size, sort);
		
		if (accountNumber != null) list = service.list(accountNumber, pageable);
		else list = service.list(source, reference, pageable);
		List<EntityModel<Posting>> rc =  list.stream().map(assembler::toModel)
			      .collect(Collectors.toList());

		return CollectionModel.of(rc, linkTo(methodOn(PostingController.class).list(accountNumber, source, reference, page, size, sort)).withSelfRel());
	}
	
	@PostMapping
	public ResponseEntity<?> create(@RequestBody PostingRequest newPosting) {
		Posting posting = service.create(newPosting);
		EntityModel<Posting> entityModel = assembler.toModel(posting);
		return ResponseEntity
			      .created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri())
			      .body(entityModel);
	}

	@PostMapping(path = "/tx")
	public CollectionModel<EntityModel<Posting>> create(@RequestBody List<PostingRequest> requests) {
		List<Posting> postings = new ArrayList<>();
		for (PostingRequest request : requests) {
			Posting posting = service.create(request);
			postings.add(posting);
		}
		List<EntityModel<Posting>> rc =  postings.stream().map(assembler::toModel)
			      .collect(Collectors.toList());

		return CollectionModel.of(rc, linkTo(methodOn(PostingController.class).list(null, null, null, null, null, null)).withSelfRel());		
	}
	
	@GetMapping("/{number}")
	public EntityModel<Posting> get(@PathVariable String number) {
		Posting posting = service.findById(number);
		return assembler.toModel(posting);
	}

}
