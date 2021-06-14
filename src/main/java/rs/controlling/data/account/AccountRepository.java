/**
 * 
 */
package rs.controlling.data.account;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * JPA repo interface.
 * @author ralph
 *
 */
public interface AccountRepository extends JpaRepository<Account, Long> {

}