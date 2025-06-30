package com.ecommerce.auth;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.enums.USER_ROLE;
import com.ecommerce.request.EmailRequest;
import com.ecommerce.request.SignupRequest;
import com.ecommerce.response.CustomResponse;

import jakarta.mail.MessagingException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@AllArgsConstructor

@Slf4j
public class AuthController implements AuthEndpoint {

	private final AuthService authService;

	@Override
	public ResponseEntity<Object> createUserHandler(SignupRequest req) {
		log.info("AuthController : createUserHandler() : Start ");
		String jwt =authService.createUser(req);
		AuthResponse authResponse = new AuthResponse();
		authResponse.setJwt(jwt);
		authResponse.setMessage("Registered Successfully ! ");
		authResponse.setRole(USER_ROLE.ROLE_CUSTOMER);
		log.info("AuthController : createUserHandler() : End ");
	    return CustomResponse.createBuildResponse(authResponse, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Object> sendOtp(EmailRequest req) throws MessagingException {
		
		authService.sendLoginOtp(req.getEmail());
		return null;
	}

}
