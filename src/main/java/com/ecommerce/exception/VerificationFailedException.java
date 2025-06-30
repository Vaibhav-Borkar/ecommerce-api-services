package com.ecommerce.exception;

public class VerificationFailedException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public VerificationFailedException(String message) {
		super(message);
	}
}
