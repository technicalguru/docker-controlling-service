/**
 * 
 */
package rs.controlling.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rs.controlling.data.ledger.Posting;
import rs.controlling.service.PostingRequest;
import rs.controlling.service.PostingService;

/**
 * The REST controller
 * @author ralph
 *
 */
@RestController
@RequestMapping(path = "/postings")
public class PostingController {

	@Autowired
	private PostingService service;

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
	public List<Posting> list() {
		return service.list();
	}
	
	@PostMapping
	public Posting create(@RequestBody PostingRequest newPosting) {
		return service.create(newPosting);
	}

	// TODO never on uid, better on number
	@GetMapping("/{number}")
	public Posting get(@PathVariable String number) {
		return service.findById(number);
	}

}
