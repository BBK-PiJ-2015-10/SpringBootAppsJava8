package myspringboot.mybatchprocessing.fileprocessing;

import java.util.logging.Logger;
import java.util.logging.Level;

import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class JobCompletionNotificationListener extends JobExecutionListenerSupport {
	
	private static final Logger LOGGER = Logger.getLogger(JobCompletionNotificationListener.class.getName());
	
	private final JdbcTemplate jdbcTemplate;

	@Autowired
	public JobCompletionNotificationListener(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@Override
	public void afterJob(JobExecution jobExecution){
		if (jobExecution.getStatus() == BatchStatus.COMPLETED){
			LOGGER.log(Level.INFO,"!!! JOB FINISHED Time to verify the results");
			
			jdbcTemplate.query("SELECT first_name, last_name FROM people",
					(rs, row) -> new Person(
							rs.getString(1),
							rs.getString(2))
					).forEach(person -> LOGGER.log(Level.INFO,"Found <" + person +"> in the database"));
		}
	}	
	

}
