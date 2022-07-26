package com.shopforhome.discountservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddDiscountModel {
	
	private Integer product_id;
	private Integer discount_percentage;
	private Integer actual_price;
}
