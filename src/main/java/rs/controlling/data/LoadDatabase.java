/**
 * 
 */
package rs.controlling.data;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import rs.controlling.service.AccountService;
import rs.controlling.service.PostingService;

/**
 * Load the initial database.
 * @author ralph
 *
 */
@Configuration
public class LoadDatabase {

	private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

	@Bean
	CommandLineRunner initDatabase(AccountService accounts, PostingService postings) {
		return args -> {
			/*
			Account acct1 = accounts.create(new Account("0123", AccountType.ASSETS, AccountSubType.INVENTORY, "Account 1", "Description 1", true));
			Account acct2 = accounts.create(new Account("0124", AccountType.LIABILITIES, AccountSubType.PROFIT_LOSS, "Account 2", "Description 2", true));

			PostingRequest request = new PostingRequest(PostingType.EXTENSION, "ticket-bob.com", "P2100001", "Some text", BigDecimal.valueOf(1017, 2), acct1, acct2);
			postings.create(request);
			*/
			log.info("Initialized database");
		};
	}
}
