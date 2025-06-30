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
public class BusinessDetails {

	private String businessName;

	private String businessEmail;

	private String businessMobile;

	private String businessAddress;

	private String logo;

	private String banner;

}
