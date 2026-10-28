package com.hrms.empilot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing 
public class EmpilotApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmpilotApplication.class, args);
	}

}
