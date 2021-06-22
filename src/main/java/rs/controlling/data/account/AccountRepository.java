/**
 * 
 */
package rs.controlling.data.account;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * JPA repo interface.
 * @author ralph
 *
 */
public interface AccountRepository extends JpaRepository<Account, Long> {

	Account       findByAccountNumber(String accountNumber);
	List<Account> findByAccountTypeAndAccountSubType(AccountType accountType, AccountSubType accountSubType);
	List<Account> findByAccountType(AccountType accountType);
	List<Account> findByAccountSubType(AccountSubType accountSubType);
	
}
