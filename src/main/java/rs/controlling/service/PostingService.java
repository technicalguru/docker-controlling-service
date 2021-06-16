/**
 * 
 */
package rs.controlling.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import rs.controlling.data.account.AccountRepository;
import rs.controlling.data.ledger.AccountPostingRepository;
import rs.controlling.data.ledger.Posting;
import rs.controlling.data.ledger.PostingNotFoundException;
import rs.controlling.data.ledger.PostingRepository;

/**
 * Handles entry of new postings.
 * @author ralph
 *
 */
@Component
public class PostingService {

	@Autowired
	private PostingRepository postings;
	@Autowired
	private AccountPostingRepository details;
	@Autowired
	private AccountRepository accounts;

	/**
	 * Constructor.
	 */
	public PostingService() {
	}

	public List<Posting> list() {
		return postings.findAll();
	}
	
	public Posting create(PostingRequest posting) {
		// TODO check validity
		// Is there the same posting number (if given)
		// Check source and source Reference (must not exist)
		// accounts must exist
		// Depending on type: check credit/debit types and account aktiva/passiva type
		
		// Posting rc = postings.save(posting);
		// Update both accounts
		return null;
	}
	
	public Posting findById(String number) {
		Posting rc = postings.findByPostingNumber(number);
		if (rc == null) throw new PostingNotFoundException(number);
		return rc;
	}
}
