package springdata.jpaexample;

import java.util.logging.Logger;
import java.util.logging.Level;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JpaExampleApplication {

	private static Logger LOGGER = Logger.getLogger(JpaExampleApplication.class.getName());

	public static void main(String[] args) {
		SpringApplication.run(JpaExampleApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(CustomerRepository repository) {
		return (args) -> {

			// save a couple of customers
			repository.save(new Customer("Jack", "Daniel"));
			repository.save(new Customer("Chivas", "Regal"));
			repository.save(new Customer("Flor", "DeCana"));
			repository.save(new Customer("Berliner", "Bier"));
			repository.save(new Customer("Red", "Bull"));
			repository.save(new Customer("RadenBerger", "Bier"));

			// fetch all customers
			LOGGER.log(Level.INFO, "Customer found with findAll(): method");
			LOGGER.log(Level.INFO, "-------------------------------------");
			repository.findAll().forEach(customer -> LOGGER.log(Level.INFO, customer.toString()));
			LOGGER.log(Level.INFO, " ");

			// fetch an individual by customer id
			repository.findById(1L).ifPresent(customer -> {
				LOGGER.log(Level.INFO, "Customer found with findById(1L):");
				LOGGER.log(Level.INFO, "-------------------------------------");
				LOGGER.log(Level.INFO, customer.toString());
				LOGGER.log(Level.INFO, " ");
			});

			// fetch customers by last name
			LOGGER.log(Level.INFO, "Customer found with last name Bier");
			LOGGER.log(Level.INFO, "-------------------------------------");
			repository.findByLastName("Bier").forEach(customer -> LOGGER.log(Level.INFO, customer.toString()));
			LOGGER.log(Level.INFO, " ");

		};

	}

}
