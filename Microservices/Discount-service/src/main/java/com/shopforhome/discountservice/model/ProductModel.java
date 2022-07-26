package com.shopforhome.discountservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductModel {
	private Integer product_id;
	private String product_type;
	private Integer product_stock;
	private String product_name;
	private String image_url;
	private Integer product_price;
	private Boolean offer_aval;
	private Boolean offer_used;
	private Integer discount_price;
}
