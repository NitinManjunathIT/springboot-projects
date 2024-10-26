package in.pwskills.nitin.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderRestController {
	@GetMapping("/item")
	public ResponseEntity<String> createOrder() {
		return new ResponseEntity<String>("HELLO USERS!!", HttpStatus.OK);
	}
}
