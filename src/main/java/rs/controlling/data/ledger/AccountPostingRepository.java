/**
 * 
 */
package rs.controlling.data.ledger;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import rs.controlling.data.account.Account;

/**
 * JPA repo interface.
 * @author ralph
 *
 */
public interface AccountPostingRepository extends JpaRepository<AccountPosting, Long> {

	List<AccountPosting> findByAccount(Account account);
	List<AccountPosting> findByPosting(Posting posting);
}
