package com.file.flat.config;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.core.io.FileSystemResource;

import com.file.flat.alert.JobCompletionNotificationListener;
import com.file.flat.dto.Employee;
import com.file.flat.processor.EmployeeProcessor;

@EnableBatchProcessing
@Configuration
@Component
public class CsvToH2DB {
	@Autowired
	public JobBuilderFactory jobBuilderFactory;

	@Autowired
	public StepBuilderFactory stepBuilderFactory;

	@Autowired
	public DataSource dataSource;

	@Bean
	public FlatFileItemReader<Employee> csvEmployeeReader() {
		FlatFileItemReader<Employee> reader = new FlatFileItemReader<Employee>();
		//If flat file located inside the project directory
		reader.setResource(new ClassPathResource("employees.csv"));
		//If flat file located in file system
		//reader.setResource(new FileSystemResource("D:\\flat-file\\employees.csv"));
		reader.setLinesToSkip(1);
		reader.setLineMapper(new DefaultLineMapper<Employee>() {
			{
				setLineTokenizer(new DelimitedLineTokenizer() {
					{
						setNames(new String[] { "id", "name", "company", "branch" });
					}
				});
				setFieldSetMapper(new BeanWrapperFieldSetMapper<Employee>() {
					{
						setTargetType(Employee.class);
					}
				});
			}
		});
		return reader;
	}

	@Bean
	ItemProcessor<Employee, Employee> csvEmployeeProcessor() {
		return new EmployeeProcessor();
	}

	@Bean
	public JdbcBatchItemWriter<Employee> csvEmployeeWriter() {
		JdbcBatchItemWriter<Employee> csvEmployeeWriter = new JdbcBatchItemWriter<Employee>();
		csvEmployeeWriter.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<Employee>());
		csvEmployeeWriter
				.setSql("INSERT INTO employees (id, name, company, branch) VALUES (:id, :name, :company, :branch)");
		csvEmployeeWriter.setDataSource(dataSource);
		return csvEmployeeWriter;
	}

	@Bean
	public Step csvFileToDatabaseStep() {
		return stepBuilderFactory.get("csvFileToDatabaseStep").<Employee, Employee>chunk(1).reader(csvEmployeeReader())
				.processor(csvEmployeeProcessor()).writer(csvEmployeeWriter()).build();
	}

	@Bean
	Job csvFileToDatabaseJob(JobCompletionNotificationListener listener) {
		return jobBuilderFactory.get("csvFileToDatabaseJob").incrementer(new RunIdIncrementer()).listener(listener)
				.flow(csvFileToDatabaseStep()).end().build();
	}
}
