package com.duoqio.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.duoqio.cloud.orm.jpa.repository.BaseRepositoryImpl;

@SpringBootApplication
@EnableJpaRepositories(repositoryBaseClass = BaseRepositoryImpl.class)
public class CloudProject {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(CloudProject.class, args);
	}
	
}
