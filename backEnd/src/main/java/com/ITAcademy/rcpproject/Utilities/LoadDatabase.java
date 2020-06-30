package com.ITAcademy.rcpproject.Utilities;

import org.springframework.context.annotation.Configuration;

import com.ITAcademy.rcpproject.Models.Employee;
import com.ITAcademy.rcpproject.Models.Role;
import com.ITAcademy.rcpproject.Repositories.EmployeeRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;




@Configuration
public class LoadDatabase {
	
	 @Bean
	 CommandLineRunner initDatabase(EmployeeRepository repository) {
			
			return args -> {
				System.out.println("Preloading Data to memory Database");
				repository.save(new Employee("Bilbo Baggins", Role.BOSS, Role.BOSS.name(), Role.BOSS.getSalary()));
				repository.save(new Employee("Frodo Baggins", Role.ELECTRICIAN, Role.ELECTRICIAN.name(), Role.ELECTRICIAN.getSalary()));
				System.out.println("Data loaded");
			};
	 }
}
