package com.sistemafinanciero.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sistemafinanciero.Exception.Apiunauthorized;
import com.sistemafinanciero.Service.AuthService;
import com.sistemafinanciero.Validator.AuthValidator;

@RestController
@RequestMapping(path="v1.0")
@CrossOrigin(origins = "*")
public class AuthController {
	
	@Autowired
	private AuthService authService;
	@Autowired
	private AuthValidator authValidator;
	
	@PostMapping(path="oauth/client_credential/accesstoken", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object>login(@RequestBody MultiValueMap<String, String> paramMap, @RequestParam("grant_type")String grantType) throws Apiunauthorized{
		
		authValidator.validate(paramMap, grantType);
		
		return ResponseEntity.ok(authService.login(paramMap.getFirst("client_id"), paramMap.getFirst("client_secret")));
	}

}
