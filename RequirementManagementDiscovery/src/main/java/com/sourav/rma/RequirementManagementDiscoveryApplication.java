package com.sourav.rma;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class RequirementManagementDiscoveryApplication {

	public static void main(String[] args) {
		SpringApplication.run(RequirementManagementDiscoveryApplication.class, args);
	}

}
