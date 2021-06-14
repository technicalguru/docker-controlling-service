package rs.controlling.svc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"rs.controlling"})
@EntityScan("rs.controlling")
@EnableJpaRepositories("rs.controlling")
public class ServiceForControllingApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceForControllingApplication.class, args);
	}

}
