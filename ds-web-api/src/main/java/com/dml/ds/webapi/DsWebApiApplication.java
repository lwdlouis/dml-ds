package com.dml.ds.webapi;

import com.spring4all.mongodb.EnableMongoPlus;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@EnableEurekaClient
@EnableMongoPlus
@EnableReactiveMongoRepositories
@SpringBootApplication
public class DsWebApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(DsWebApiApplication.class, args);
	}

}
