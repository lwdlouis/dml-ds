package com.dml.ds.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class DsGatewaySpringCloudApplication {

	public static void main(String[] args) {
		SpringApplication.run(DsGatewaySpringCloudApplication.class, args);
	}

}
