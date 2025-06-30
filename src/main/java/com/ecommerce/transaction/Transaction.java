package com.ecommerce.transaction;

import java.time.LocalDateTime;

import com.ecommerce.order.Order;
import com.ecommerce.seller.Seller;
import com.ecommerce.user.User;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@ManyToOne
	private User user;
	
	@OneToOne
	private Order order;
	
	@ManyToOne
	private Seller seller;
	
	private LocalDateTime date = LocalDateTime.now();
}
