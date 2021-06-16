/**
 * 
 */
package rs.controlling.data.ledger;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * JPA repo interface.
 * @author ralph
 *
 */
public interface PostingRepository extends JpaRepository<Posting, Long> {

	public Posting findByPostingNumber(String number);
}
