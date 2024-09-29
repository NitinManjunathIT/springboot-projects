package in.pwskills.nitin.consumer;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import in.pwskills.nitin.response.Cart;

@FeignClient("CART-SERVICE")
public interface ICartConsumer {

	@GetMapping("/v1/api/cart/show")
	public ResponseEntity<String> getCartInfo();
	
	@GetMapping("/v1/api/cart/find/{id}")
	public ResponseEntity<Cart> getCartById(
			@PathVariable Integer id) ;
	
	@PostMapping("/v1/api/cart/create")
	public ResponseEntity<String> addCartDetails(
			@RequestBody Cart cart);
		
}
