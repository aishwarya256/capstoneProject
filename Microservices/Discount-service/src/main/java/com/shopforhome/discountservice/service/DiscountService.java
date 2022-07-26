package com.shopforhome.discountservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopforhome.discountservice.entity.DiscountEntity;
import com.shopforhome.discountservice.repository.DiscountRepository;

@Service
public class DiscountService {
	
	@Autowired
	private DiscountRepository discountrepo;
	
//	To add new discount on a specific product
	public Boolean setDiscount(DiscountEntity discountentity){
		try {
			discountrepo.save(discountentity);
			return true;
		}
		catch(Exception ex) {
			System.out.println("Error in setting discount:"+ex);
			return false;
		}
	}
	
	
	//To find if that particular product has discount or not using product id
	public Boolean getDiscountByProductId(Integer product_id){
		try {
		List<DiscountEntity> data = discountrepo.findByProductId(product_id);
		if(data.isEmpty())
			return false;
		else
			return true;
		}
		catch(Exception ex) {
			System.out.println("Exception in checking if discount is present in Discount service: "+ex);
			return false;
		}
	}

}
