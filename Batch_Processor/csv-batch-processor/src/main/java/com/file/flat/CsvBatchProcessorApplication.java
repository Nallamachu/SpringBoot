package com.file.flat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class CsvBatchProcessorApplication {

	public static void main(String[] args) {
		SpringApplication.run(CsvBatchProcessorApplication.class, args);
	}

}

