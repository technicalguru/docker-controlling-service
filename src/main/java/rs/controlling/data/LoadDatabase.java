/**
 * 
 */
package rs.controlling.data;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import rs.controlling.data.account.Account;
import rs.controlling.data.account.AccountRepository;
import rs.controlling.data.account.AccountSubType;
import rs.controlling.data.account.AccountType;
import rs.controlling.data.ledger.AccountPosting;
import rs.controlling.data.ledger.AccountPostingRepository;
import rs.controlling.data.ledger.AccountPostingType;
import rs.controlling.data.ledger.Posting;
import rs.controlling.data.ledger.PostingRepository;
import rs.controlling.data.ledger.PostingType;

/**
 * Load the initial database.
 * @author ralph
 *
 */
@Configuration
public class LoadDatabase {

	private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

	@Bean
	CommandLineRunner initDatabase(AccountRepository repository, PostingRepository pRepository, AccountPostingRepository dRepository) {
		return args -> {
			Account acct1   = repository.save(new Account("0123", AccountType.AKTIVA, AccountSubType.BALANCE, "Account 1", "Description 1", true));
			log.info("Preloading " + acct1);
			Account acct2   = repository.save(new Account("0124", AccountType.PASSIVA, AccountSubType.PROFIT_LOSS, "Account 2", "Description 2", true));
			log.info("Preloading " + acct2);
			Posting posting = pRepository.save(new Posting("1234567890", PostingType.EXTENSION, "ticket-bob.com", "P2100001", ZonedDateTime.now(), "Some text"));
			log.info("Preloading " + posting);
			AccountPosting details1 = dRepository.save(new AccountPosting("1234567890", "0123", AccountPostingType.DEBIT, BigDecimal.valueOf(1017, 2)));
			log.info("Preloading " + details1);
			AccountPosting details2 = dRepository.save(new AccountPosting("1234567890", "0124", AccountPostingType.CREDIT, BigDecimal.valueOf(1017, 2)));
			log.info("Preloading " + details2);
		};
	}
}
