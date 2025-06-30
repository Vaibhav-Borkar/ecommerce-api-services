package com.ecommerce.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.ecommerce.response.CustomResponse;

import lombok.extern.slf4j.Slf4j;

@ControllerAdvice 
@Slf4j
public class GlobalExceptionHandler {

	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> handleGlobalException(Exception e) {
		log.info("GlobalExceptionHandler : handleGlobalException() : {}",e.getMessage());
		return  CustomResponse.createErrorResponseMessage(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
	}
	
	
	@ExceptionHandler(VerificationFailedException.class)
	public ResponseEntity<Object> handleVerificationFailedException(VerificationFailedException e){
		log.info("GlobalExceptionHandler : handleVerificationFailedException() : {}",e.getMessage());
		return  CustomResponse.createErrorResponseMessage(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
	}
	
	
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<Object> handleUserNotFoundException(UserNotFoundException e){
		log.info("GlobalExceptionHandler : handleUserNotFoundException() : {}",e.getMessage());
		return  CustomResponse.createErrorResponseMessage(HttpStatus.NOT_FOUND, e.getMessage());
	}
	
}
