package com.ecommerce.seller;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
public class SellerReport {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@OneToOne
	private Seller seller;
	
	private Long totalEarnings= 0l;
	
	private Long totalSeles= 0l;
	
	private Long totalRefunds = 0l;
	
	private Long totalTax = 0l;
	
	private Long netEarning =0l;
	
	private Integer totalOrders=0;
	
	private Integer canceledOrders =0;
	
	private Integer totalTransactions =0;
	
	
	
	
}
