package com.shopforhome.products.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Entity
@Table(name="products_table")
public class ProductsEntity {
	
	public ProductsEntity() {}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer product_id;
	
	@Column(name="product_type")
	private String product_type;
	
	@Column(name="product_stock")
	private Integer product_stock;
	
	@Column(name="product_name")
	private String product_name;
	
	@Column(name="image_url")
	private String image_url;
	
	@Column(name="product_price")
	private Integer product_price;
	
	
	

}
