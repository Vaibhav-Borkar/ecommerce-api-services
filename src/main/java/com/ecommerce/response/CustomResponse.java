package com.ecommerce.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.ecommerce.constants.CustomResponseConstant;

import jakarta.servlet.http.HttpServletRequest;

public class CustomResponse {
	
	private CustomResponse() {
		
	}

	public static ResponseEntity<Object> createBuildResponse(Object data,HttpStatus status){
		GenericResponse response=GenericResponse.builder()
				.responseStatus(status)
				.status(CustomResponseConstant.SUCCESS)
				.message(CustomResponseConstant.SUCCESS)
				.data(data)
				.build();
		return response.create();
	}
	
	public static ResponseEntity<Object> createBuildResponseMessage(HttpStatus status,String message){
		GenericResponse response=GenericResponse.builder()
				.responseStatus(status)
				.status(CustomResponseConstant.SUCCESS)
				.message(message)
				.build();
		return response.create();
	}
	
	
	public static ResponseEntity<Object> createErrorResponse(Object data,HttpStatus status){
		GenericResponse response=GenericResponse.builder()
				.responseStatus(status)
				.status(CustomResponseConstant.FAILED)
				.message(CustomResponseConstant.FAILED)
				.data(data)
				.build();
		return response.create();
	}
	
	
	public static ResponseEntity<Object> createErrorResponseMessage(HttpStatus status,String message){
		GenericResponse response=GenericResponse.builder()
				.responseStatus(status)
				.status(CustomResponseConstant.FAILED)
				.message(message)
				.build();
		return response.create();
	}

	public static String getUrl(HttpServletRequest req) {
		String apiUrl = req.getRequestURL().toString(); // http://localhost:8080/api/v1/auth
		apiUrl= apiUrl.replace(req.getServletPath(), "");
		return apiUrl; // http://localhost:8080
	}

//	public static User getLoggedInUser() {
//		CustomUserDetails loggedUser=(CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//		return loggedUser.getUser();
//	}
	
}