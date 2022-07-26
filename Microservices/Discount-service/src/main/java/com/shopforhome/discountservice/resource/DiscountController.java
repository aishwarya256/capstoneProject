package com.shopforhome.discountservice.resource;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.shopforhome.discountservice.entity.DiscountEntity;
import com.shopforhome.discountservice.model.AddDiscountModel;
import com.shopforhome.discountservice.model.ProductModel;
import com.shopforhome.discountservice.response.WebResponse;
import com.shopforhome.discountservice.service.DiscountService;

@RestController
@RequestMapping("/discount")
public class DiscountController {

	@Autowired
	private DiscountService discountservice;

	@Autowired
	private RestTemplate res;

	@PostMapping("/setDiscount")
	public ResponseEntity<WebResponse> setDiscount(@RequestBody AddDiscountModel discountmodel) {
		Boolean isPresent = discountservice.getDiscountByProductId(discountmodel.getProduct_id());
		if (!isPresent) {
			float actual_price = discountmodel.getActual_price();
			float discount_amount = discountmodel.getDiscount_percentage() / 100f * actual_price;
			Integer rounded_discount_amount = Math.round(discount_amount);
			Integer new_price = discountmodel.getActual_price() - rounded_discount_amount;
			DiscountEntity discountentity = new DiscountEntity(discountmodel.getProduct_id(),
					discountmodel.getDiscount_percentage(), discountmodel.getActual_price(), new_price);
			Boolean status = discountservice.setDiscount(discountentity);
			if (status) {
				ProductModel productmodel = res.getForObject(
						"http://localhost:8183/product/Product/" + discountmodel.getProduct_id(), ProductModel.class);
				productmodel.setOffer_aval(true);
				productmodel.setOffer_used(false);
				productmodel.setDiscount_price(new_price);

				WebResponse response = res.postForObject("http://localhost:8183/product/update/", productmodel,
						WebResponse.class);
				if (response.getStatus()) {
					return ResponseEntity.ok(new WebResponse(true, "Success", discountentity));
				} else {
					return ResponseEntity.badRequest().body(new WebResponse(false, "Failed", discountentity));
				}
			}
			else {
				return ResponseEntity.badRequest().body(new WebResponse(false, "Failed", discountentity));
			}
		} else {
			return ResponseEntity.badRequest().body(new WebResponse(false, "Discount already present for this product",discountservice));
		}
	}

}
