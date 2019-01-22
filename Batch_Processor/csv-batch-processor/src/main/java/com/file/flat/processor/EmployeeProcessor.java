package com.file.flat.processor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.file.flat.dto.Employee;

@Component
public class EmployeeProcessor implements ItemProcessor<Employee, Employee> {
	private static final Logger logger = LoggerFactory.getLogger(EmployeeProcessor.class);

	@Override
	public Employee process(Employee item) throws Exception {
		logger.info("Entering into process() method");
		int id = item.getId();
		String name = item.getName();
		String company = item.getCompany();
		String branch = item.getBranch();
		final Employee finalDTO = new Employee(id, name, company, branch);
		logger.info("Converting (" + item + ") into (" + finalDTO + ")");
		return finalDTO;
	}

}
