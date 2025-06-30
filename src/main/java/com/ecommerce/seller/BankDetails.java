package com.ecommerce.seller;



import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BankDetails {

	private String accountNumber;
	
	private String accountHolderName;
	
	private String ifscCode;
}
