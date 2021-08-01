package com.sourav.rma;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import io.jsonwebtoken.Jwts;
import reactor.core.publisher.Mono;

@Component
public class AuthorizationPreFilter {//implements GlobalFilter {
	
//	@Autowired
//	private Environment env; 
//
//	@Override
//	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
//		ServerHttpRequest request = exchange.getRequest();
//		if(request.getHeaders().containsKey(HttpHeaders.AUTHORIZATION)) {
//			return onError(exchange, "No authorization Header", HttpStatus.UNAUTHORIZED);
//		}
//		
//		String authorizationHeader = request.getHeaders().get(HttpHeaders.AUTHORIZATION).get(0);
//		String jwt = authorizationHeader.replace("Bearer","");
//		
//		if(!isJWTValid(jwt)) {
//			return onError(exchange, "JWT Token is not valid", HttpStatus.UNAUTHORIZED);
//		}
//		return chain.filter(exchange);
//	}
//	
//	private Mono<Void> onError(ServerWebExchange exchange, String string, HttpStatus unauthorized) {
//		ServerHttpResponse response = exchange.getResponse();
//		response.setStatusCode(unauthorized);
//		return response.setComplete();
//	}
//	
//	private boolean isJWTValid(String jwt) {
//		boolean returnValue = true;
//		String subject = Jwts.parser()
//							 .setSigningKey(env.getProperty("token.secret"))
//							 .parseClaimsJwt(jwt)
//							 .getBody()
//							 .getSubject();
//		
//		if(subject == null || subject.isEmpty()) {
//			returnValue = false;
//		}
//		return returnValue;
//	}

}
