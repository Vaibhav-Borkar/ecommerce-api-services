package com.ecommerce.home;

import java.util.List;

import com.ecommerce.category.HomeCategory;
import com.ecommerce.deal.Deal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Home {

	private List<HomeCategory> grid;
	
	private List<HomeCategory> shopByCategories;
	
	private List<HomeCategory> electricCategories;
	
	private List<HomeCategory> dealCategories;
	
	private List<Deal> deals;
	
}
