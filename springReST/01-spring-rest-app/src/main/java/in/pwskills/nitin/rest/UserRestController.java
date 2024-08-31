package in.pwskills.nitin.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/api/user")
public class UserRestController {

	
	/*
	 * METHOD : GET
	 * PATH   : /get
	 * R.T    : ResponseEntity<String> + STATUSCODE(200)
	 * Input  : No input
	 */
	
	@GetMapping("/get")
	public ResponseEntity<String> getUser(){
		return new ResponseEntity<>("FROM GET REQUEST",HttpStatus.OK);
	}
	
	/*
	 * METHOD : POST
	 * PATH   : /post
	 * R.T    : ResponseEntity<String> + STATUSCODE(200)
	 * Input  : No input
	 */
	@PostMapping("/post")
	public ResponseEntity<String> postUser(){
		return new ResponseEntity<>("FROM POST REQUEST",HttpStatus.OK);
	}
	
	/*
	 * METHOD : PUT
	 * PATH   : /put
	 * R.T    : ResponseEntity<String> + STATUSCODE(200)
	 * Input  : No input
	 */
	@PutMapping("/put")
	public ResponseEntity<String> putUser(){
		return new ResponseEntity<>("FROM PUT REQUEST",HttpStatus.OK);
	}
	
	/*
	 * METHOD : DELETE
	 * PATH   : /delete
	 * R.T    : ResponseEntity<String> + STATUSCODE(200)
	 * Input  : No input
	 */
	@DeleteMapping("/delete")
	public ResponseEntity<String> deleteUser(){
		return new ResponseEntity<>("FROM DELETE REQUEST",HttpStatus.OK);
	}
	
}
