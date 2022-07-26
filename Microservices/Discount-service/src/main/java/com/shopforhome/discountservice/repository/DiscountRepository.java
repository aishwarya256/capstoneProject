package com.shopforhome.discountservice.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shopforhome.discountservice.entity.DiscountEntity;

@Repository
public interface DiscountRepository extends JpaRepository<DiscountEntity, Integer> {
 List<DiscountEntity> findByProductId(Integer productId);
 
}
