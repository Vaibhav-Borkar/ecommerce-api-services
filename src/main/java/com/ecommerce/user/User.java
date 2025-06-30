package com.ecommerce.user;

import java.util.HashSet;
import java.util.Set;

import com.ecommerce.address.Address;
import com.ecommerce.coupon.Coupon;
import com.ecommerce.enums.USER_ROLE;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY) // Not access in api response
	private String password;

	
	private String email;

	private String fullname;

	private String mobile;

	private USER_ROLE role = USER_ROLE.ROLE_CUSTOMER;

	@OneToMany
	private Set<Address> address = new HashSet<>();

	@ManyToMany
	@JsonIgnore // To ignote this data in api
	private Set<Coupon> usedCoupons = new HashSet<>();
	
	

}
