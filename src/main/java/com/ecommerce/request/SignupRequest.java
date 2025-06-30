package com.ecommerce.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignupRequest {

	private String fullName;
	
	private String email;
	
	private String otp;
}
