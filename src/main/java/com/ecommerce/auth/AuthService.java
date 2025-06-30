package com.ecommerce.auth;

import com.ecommerce.request.SignupRequest;

import jakarta.mail.MessagingException;

public interface AuthService {

	String createUser (SignupRequest req);
	void sendLoginOtp (String email) throws MessagingException;
}
