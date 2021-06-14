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
public interface AccountPostingRepository extends JpaRepository<AccountPosting, Long> {

	List<AccountPosting> findByAccountNumber(String accountNumber);
	List<AccountPosting> findByPostingNumber(String postingNumber);
}
