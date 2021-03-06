package rs.controlling.svc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@ComponentScan({"rs.controlling"})
@EntityScan("rs.controlling")
@EnableJpaRepositories("rs.controlling")
@EnableTransactionManagement
public class ServiceForControllingApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceForControllingApplication.class, args);
	}

}
