package com.pmtech.doctorcrudservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;


@SpringBootApplication
@EnableMongoRepositories
public class DoctorCrudServiceApplication  implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DoctorCrudServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

	}
}

