/**
 * 
 */
package rs.controlling.data;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import rs.controlling.data.account.Account;
import rs.controlling.data.account.AccountRepository;
import rs.controlling.data.account.AccountSubType;
import rs.controlling.data.account.AccountType;

/**
 * Load the initial database.
 * @author ralph
 *
 */
@Configuration
public class LoadDatabase {

	private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

	@Bean
	CommandLineRunner initDatabase(AccountRepository repository) {
		return args -> {
			log.info("Preloading " + repository.save(new Account("0123", AccountType.AKTIVA, AccountSubType.BALANCE, "Account 1", "Description 1", true)));
			log.info("Preloading " + repository.save(new Account("0124", AccountType.PASSIVA, AccountSubType.PROFIT_LOSS, "Account 2", "Description 2", true)));
		};
	}
}
