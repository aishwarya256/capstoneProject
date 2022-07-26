package com.shopforhome.discountservice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="discount_table")
@Data
@NoArgsConstructor
public class DiscountEntity {

	public DiscountEntity(Integer product_id,
			Integer discount_percentage,Integer actual_price,Integer discount_price) {
		this.productId = product_id;
		this.discount_percentage = discount_percentage;
		this.actual_price = actual_price;
		this.discount_price = discount_price;
	}
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer discount_id;
	
	@Column(name="product_id",unique = true)
	private Integer productId;
	
	@Column(name="discount_percentage")
	private Integer discount_percentage;
	
	@Column(name="actual_price")
	private Integer actual_price;
	
	@Column(name="discount_price")
	private Integer discount_price;
	
}
