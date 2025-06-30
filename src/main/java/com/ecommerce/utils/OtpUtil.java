package com.ecommerce.utils;

import java.security.SecureRandom;

public class OtpUtil {

	
	private OtpUtil() {
	}

	public static String generateOtp() {

		int otpLength = 6;

		SecureRandom random = new SecureRandom(); // better than Random for security

		StringBuilder otp = new StringBuilder(otpLength);

		for (int i = 0; i < otpLength; i++) {
			otp.append(random.nextInt(10)); // digit from 0 to 9
		}

		return otp.toString();
	}
}
