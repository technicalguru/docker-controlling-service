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

import rs.controlling.data.account.AccountRepository;
import rs.controlling.data.ledger.AccountPostingRepository;
import rs.controlling.data.ledger.Posting;
import rs.controlling.data.ledger.PostingNotFoundException;
import rs.controlling.data.ledger.PostingRepository;

/**
 * The REST controller
 * @author ralph
 *
 */
@RestController
@RequestMapping(path = "/postings")
public class PostingController {

	@Autowired
	private PostingRepository repository;
	@Autowired
	private AccountPostingRepository detailsRepository;
	@Autowired
	private AccountRepository accountRepository;

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
		return repository.findAll();
	}
	
	@PostMapping
	public Posting newPosting(@RequestBody Posting newPosting) {
		return repository.save(newPosting);
	}

	// TODO never on uid, better on number
	@GetMapping("/{id}")
	public Posting get(@PathVariable Long id) {
		return repository.findById(id)
				.orElseThrow(() -> new PostingNotFoundException(id));
	}

}
