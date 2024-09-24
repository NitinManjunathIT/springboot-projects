package in.pwskills.nitin.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/api/product")
public class CartServiceController {

	@GetMapping("/cart")
	public ResponseEntity<String> getProduct(){
		return ResponseEntity.ok("GETTING OUTPUT OF MS#1 THROUGH EUREKA SERVER...");
	}
	
}
