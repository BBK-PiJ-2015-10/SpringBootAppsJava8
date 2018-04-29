package myspringboot.mybatchprocessing.fileprocessing;

import java.util.logging.Logger;

import org.springframework.batch.item.ItemProcessor;

import java.util.logging.Level;

public class PersonItemProcessor implements ItemProcessor<Person,Person> {
	
	private static final Logger LOGGER = Logger.getLogger(PersonItemProcessor.class.getName());

	@Override
	public Person process(final Person person) throws Exception {
		final String firstName = person.getFirstName().toUpperCase();
		final String lastName = person.getLastName().toUpperCase();
		
		final Person transformedPerson = new Person(firstName,lastName);
		
		LOGGER.log(Level.INFO,"Converting (" +person +") into (" +transformedPerson +")");
		
		return transformedPerson;
	}
	
	

}
