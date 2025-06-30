package com.ecommerce.auth;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ecommerce.cart.Cart;
import com.ecommerce.cart.CartRepository;
import com.ecommerce.enums.USER_ROLE;
import com.ecommerce.exception.UserNotFoundException;
import com.ecommerce.exception.VerificationFailedException;
import com.ecommerce.request.SignupRequest;
import com.ecommerce.security.JwtProvider;
import com.ecommerce.service.EmailService;
import com.ecommerce.user.User;
import com.ecommerce.user.UserRepository;
import com.ecommerce.utils.OtpUtil;
import com.ecommerce.verification.VerificationCode;
import com.ecommerce.verification.VerificationCodeRepository;

import jakarta.mail.MessagingException;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AuthServiceImpl implements AuthService {

	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;
	private final CartRepository cartRepository;
	private final JwtProvider jwtProvider;
	private final VerificationCodeRepository verificationCodeRepository;
	private final EmailService emailService;

	@Override
	public String createUser(SignupRequest req) {

		VerificationCode verificationCode = verificationCodeRepository.findByEmail(req.getEmail());
		if (verificationCode == null || !verificationCode.getOtp().equals(req.getOtp())) {
			throw new VerificationFailedException("wrong otp verification failed");
		}
		User user = userRepository.findByEmail(req.getEmail());

		if (user == null) {
			User createdUser = new User();
			createdUser.setEmail(req.getEmail());
			createdUser.setFullname(req.getFullName());
			createdUser.setRole(USER_ROLE.ROLE_CUSTOMER);
			createdUser.setMobile("2345678909");
			createdUser.setPassword(passwordEncoder.encode(req.getOtp()));
			user = userRepository.save(createdUser);

			Cart cart = new Cart();
			cart.setUser(user);
			cartRepository.save(cart);
		}
		List<GrantedAuthority> authorities = new ArrayList<>();
		authorities.add(new SimpleGrantedAuthority(USER_ROLE.ROLE_CUSTOMER.toString()));
		Authentication authentication = new UsernamePasswordAuthenticationToken(req.getEmail(), null, authorities);
		SecurityContextHolder.getContext().setAuthentication(authentication);

		return jwtProvider.generateToken(authentication);
	}

	@Override
	public void sendLoginOtp(String email) throws MessagingException {
		final String SIGNIN_PREFIX ="signin_";
		
		if(email.startsWith(SIGNIN_PREFIX)) {
			email=email.substring(SIGNIN_PREFIX.length());
			User user = userRepository.findByEmail(email);
			if(user==null) {
				throw new UserNotFoundException("user not exist with provided email");
			}
		}
		
		VerificationCode verificationCode = verificationCodeRepository.findByEmail(email);
		
		if(verificationCode!=null) {
			verificationCodeRepository.delete(verificationCode);
		}

		String otp=OtpUtil.generateOtp();
		
		VerificationCode code = new VerificationCode();
		code.setEmail(email);
		code.setOtp(otp);
		verificationCodeRepository.save(code);
		
		String subject = "Big Bazar login/signup otp";
		String text = "Your login signup/otp is :-"+otp;
		
		emailService.sendVerificationOtpEmail(email, otp, subject, text);
	}

}
