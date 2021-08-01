package com.sourav.rma;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;

import com.sourav.rma.AuthorizationHeaderFilter.Config;

@SpringBootApplication
public class RequirementManagementApiGatewayApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(RequirementManagementApiGatewayApplication.class, args);
	}
	
	@Bean
	public RouteLocator routes(RouteLocatorBuilder builder, AuthorizationHeaderFilter preFilter) {
		return builder.routes()
				.route(p -> p.path("/users/status")
							 .and()
							 .method(HttpMethod.GET)
							 .and()
							 .header("Authorization", "Bearer (.*)")
							 .filters(req -> req.filter(preFilter.apply(new Config()))).uri("http://localhost:8052/user-ws"))
				.route(p -> p.path("/users").uri("http://localhost:8052/user-ws"))
				.route(p -> p.path("/login").uri("http://localhost:8052/user-ws"))
				.build();
	}

}
