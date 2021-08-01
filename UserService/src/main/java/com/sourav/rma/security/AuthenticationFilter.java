package com.sourav.rma.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.env.Environment;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sourav.rma.dto.LoginDto;
import com.sourav.rma.service.UserService;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class AuthenticationFilter extends UsernamePasswordAuthenticationFilter {
	
	private UserService userService;
	private Environment env;
	
	public AuthenticationFilter(UserService userService2, Environment env2, AuthenticationManager authenticationManager) {
		this.userService = userService2;
		this.env = env2;
		super.setAuthenticationManager(authenticationManager);
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws AuthenticationException{

		LoginDto credentials;
		try {
			credentials = new ObjectMapper().readValue(httpServletRequest.getInputStream(), LoginDto.class);

			return getAuthenticationManager().authenticate(
						new UsernamePasswordAuthenticationToken(
													credentials.getUserId(), 
													credentials.getPassword(),
													new ArrayList<>())
						);
		} catch (IOException e) {
		}
		return null;
	}
	
	@Override
	protected void successfulAuthentication(HttpServletRequest httpServletRequest,
										   	HttpServletResponse httpServletResponse,
										   	FilterChain chain,
										   	Authentication authentication) throws IOException, ServletException {
		String userName = ((User) authentication.getPrincipal()).getUsername();
		System.out.println("UserName is : " + userName);
		com.sourav.rma.entity.User user = userService.findUserByUserId(userName);
		
		Long duration = Long.parseLong(env.getProperty("token.expiration.time"));
		String secret = env.getProperty("token.secret");
		
		String token = Jwts.builder()
						   .setSubject(user.getUserId())
						   .setExpiration(new Date(System.currentTimeMillis() + duration))
						   .signWith(SignatureAlgorithm.HS512, secret)
						   .compact();
		
		httpServletResponse.addHeader("token", token);
		httpServletResponse.addHeader("userId", user.getUserId());
	}
	

}
