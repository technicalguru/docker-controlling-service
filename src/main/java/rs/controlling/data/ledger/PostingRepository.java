/**
 * 
 */
package rs.controlling.data.ledger;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * JPA repo interface.
 * @author ralph
 *
 */
public interface PostingRepository extends JpaRepository<Posting, Long> {

	public Posting findByPostingNumber(String number);
	public List<Posting> findBySourceAndSourceReference(String source, String sourceReference);
	public List<Posting> findByAccountPostingsIn(List<AccountPosting> accountPostings);
}
