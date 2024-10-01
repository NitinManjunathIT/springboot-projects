package in.pwskills.nitin.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.pwskills.nitin.response.Cart;

@RestController
@RequestMapping("/v1/api/cart")
@RefreshScope
public class CartServiceController {
	
	@Value("${server.port}")
	private String portNo;
	
	@Value("${my.app.title}")
	private String info;

	/*
	 * METHOD  : GET
	 * PATH    : /show
	 * OUTPUT  : R.E<String>
	 * URL     : /v1/api/cart/show
	 * 
	 */
	@GetMapping("/show")
	public ResponseEntity<String> getCartDetails(){
		return ResponseEntity.ok("WELCOME TO CART SERVICE RUNNING ON :: "+portNo +"==> Data Retrieved from :: "+ info);
	}
	
	/*
	 * METHOD  : GET
	 * PATH    : /find
	 * OUTPUT  : R.E<Cart>
	 * INPUT   : id (@Pathvariable)
	 * URL     : /v1/api/cart/find/{id}
	 * 
	 */
	
	@GetMapping("/find/{id}")
	public ResponseEntity<Cart> getCartById(
				@PathVariable Integer id) {
		Cart cart = new Cart();
		cart.setCartId(id);
		cart.setCartCost(2300.0);
		cart.setCartCode("TEST");
		return ResponseEntity.ok(cart);
	}
	
	
	/*
	 * METHOD  : POST
	 * PATH    : /create
	 * OUTPUT  : R.E<String>
	 * INPUT   : Cart (@Requestbody)
	 * URL     : /v1/api/cart/create
	 * 
	 */
	@PostMapping("/create")
	public ResponseEntity<String> addToCart(
			@RequestBody Cart cart) {
		return ResponseEntity.ok("ADDED TO CART => " + cart);
	}


}
