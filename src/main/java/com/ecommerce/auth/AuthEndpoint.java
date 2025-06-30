package com.ecommerce.auth;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ecommerce.request.EmailRequest;
import com.ecommerce.request.SignupRequest;

import jakarta.mail.MessagingException;

@RequestMapping("/api/auth")
public interface AuthEndpoint {

	@PostMapping("/signup")
	public ResponseEntity<Object> createUserHandler(@RequestBody SignupRequest req);
	
	@PostMapping("/otp")
	public ResponseEntity<Object> sendOtp (@RequestBody EmailRequest req) throws MessagingException;
}
