package com.ecommerce.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ecommerce.enums.USER_ROLE;
import com.ecommerce.seller.Seller;
import com.ecommerce.seller.SellerRepository;
import com.ecommerce.user.User;
import com.ecommerce.user.UserRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CustomUserServiceImpl implements UserDetailsService {

	private final UserRepository userRepository;
	private final SellerRepository sellerRepository;
	
	private static final String SELLER_PREFIX = "seller_";

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		if (username.startsWith(SELLER_PREFIX)) {

			String actualUsername = username.substring(SELLER_PREFIX.length());
			Seller seller = sellerRepository.findByEmail(actualUsername);
			
			if(seller !=null) {
				return buildUserDetails(seller.getEmail(),seller.getPassword(),seller.getRole());
			}
		} else {
			User user = userRepository.findByEmail(username);
			if (user != null) {
				return buildUserDetails(user.getEmail(), user.getPassword(), user.getRole());
			}
		}
		throw new UsernameNotFoundException("user of seller not found with this name ");
	}

	private UserDetails buildUserDetails(String email, String password, USER_ROLE role) {
		if (role == null)
			role = USER_ROLE.ROLE_CUSTOMER;
		List<GrantedAuthority> authorityList = new ArrayList<>();
		authorityList.add(new SimpleGrantedAuthority("ROLE_" + role));

		return new org.springframework.security.core.userdetails.User(email, password, authorityList);
	}

}
