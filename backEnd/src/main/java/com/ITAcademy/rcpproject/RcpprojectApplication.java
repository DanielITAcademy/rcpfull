package com.ITAcademy.rcpproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.autoconfigure.domain.EntityScan;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
//(scanBasePackages="com.ITAcademy.rcproject")
/*@EntityScan("com.ITAcademy.rcpproject.Models")
@EnableJpaRepositories("com.ITAcademy.rcpproject.Repositories")*/
public class RcpprojectApplication {

	public static void main(String[] args) {
		SpringApplication.run(RcpprojectApplication.class, args);
	}

}
