package com.sistemafinanciero.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.sistemafinanciero.Dto.JwtResponse;
import com.sistemafinanciero.Security.JwtIO;
import com.sistemafinanciero.Util.DateUtils;

@Service
public class AuthService {
	
	@Autowired
	private JwtIO jwtIO;
	@Autowired
	private DateUtils dateUtils;
	
	@Value("${my.token.expires-in}")
	private int EXPIRES_IN;
	
	
	public JwtResponse login(String clientId, String clientSecret) {
		
		JwtResponse jwt = JwtResponse.builder()
				.tokenType("bearer")
				.accessToken(jwtIO.generateToken("Hola mundo desde AuthService"))
				.issuedAt(dateUtils.getDateMillis()+"")
				.clientId(clientId)
				.expiresIn(EXPIRES_IN)
				.build();
		
		return jwt;
		
	}
	
}
