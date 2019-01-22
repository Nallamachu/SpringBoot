package com.file.flat.alert;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.file.flat.dto.Employee;

@Component
public class JobCompletionNotificationListener extends JobExecutionListenerSupport {
	private static final Logger logger = LoggerFactory.getLogger(JobCompletionNotificationListener.class);

	private final JdbcTemplate jdbcTemplate;

	@Autowired
	public JobCompletionNotificationListener(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public void afterJob(JobExecution jobExecution) {
		if (jobExecution.getStatus() == BatchStatus.COMPLETED) {
			logger.info("============ JOB FINISHED ============ Verifying the results....\n");

			List<Employee> results = jdbcTemplate.query("SELECT id, name, company, branch FROM employees",
					new RowMapper<Employee>() {
						@Override
						public Employee mapRow(ResultSet rs, int row) throws SQLException {
							return new Employee(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
						}
					});

			for (Employee employee : results) {
				logger.info("Discovered <" + employee + "> in the database.");
			}

		}
	}
}
