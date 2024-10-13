package in.pwskills.nitin.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.pwskills.nitin.consumer.ICartConsumer;
import in.pwskills.nitin.response.Cart;

@RestController
@RequestMapping("/v1/api/order")
public class OrderRestController {

	@Value("${server.port}")
	private String portNo;
	
	/*
	 * METHOD  : GET
	 * PATH    : /place
	 * OUTPUT  : R.E<String>
	 * URL     : /v1/api/order/place
	 * 
	 */
	@Autowired
	private ICartConsumer consumer;
	
	@GetMapping("/place")
	public ResponseEntity<String> placeOrder() {
		String cartResponse = consumer.getCartInfo().getBody();
		return ResponseEntity.ok("ORDER PLACED WITH => "+cartResponse);
	}

	/*
	 * METHOD  : GET
	 * PATH    : /fetch
	 * OUTPUT  : R.E<String>
	 * URL     : /v1/api/order/fetch
	 * 
	 */
	@GetMapping("/fetch/{id}")
	public ResponseEntity<String> fetchOrderWithCart(
				@PathVariable Integer id
			) 
	{
		String cob = null;
		cob=consumer.getCartById(id).getBody();
		return ResponseEntity.ok("PORT NO OF ORDER IS :: "+portNo +"   ORDER WITH CART DATA => " 
				+ cob  );
	}

	/*
	 * METHOD  : POST
	 * PATH    : /addToCart
	 * OUTPUT  : R.E<String>
	 * URL     : /v1/api/order/addToCart
	 * 
	 */
	@PostMapping("/addToCart")
	public ResponseEntity<String> addToCart(
			@RequestBody Cart cart
			) 
	{
		String cartResp = null;
		cartResp = consumer.addCartDetails(cart).getBody();
		return ResponseEntity.ok("ORDER WITH => " + cartResp);
	}

	
	
	
	
}
