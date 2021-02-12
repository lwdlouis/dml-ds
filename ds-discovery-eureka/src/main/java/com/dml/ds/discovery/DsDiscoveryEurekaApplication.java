package com.dml.ds.discovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class DsDiscoveryEurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(DsDiscoveryEurekaApplication.class, args);
	}

}
