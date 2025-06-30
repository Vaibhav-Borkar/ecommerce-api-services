package com.ecommerce.seller;

import java.util.HashSet;
import java.util.Set;

import com.ecommerce.enums.PaymentOrderStatus;
import com.ecommerce.order.Order;
import com.ecommerce.user.User;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
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
public class PaymentOrder {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private Long amount;
	
	private String paymentLinkId;
	
	private PaymentOrderStatus  status = PaymentOrderStatus.PENDING;
	
	private PaymentMethod paymentMethod;
	
	@ManyToOne
	private User user;
	
	@OneToMany
	private Set<Order> orders = new HashSet<>();
	
	
	
}
