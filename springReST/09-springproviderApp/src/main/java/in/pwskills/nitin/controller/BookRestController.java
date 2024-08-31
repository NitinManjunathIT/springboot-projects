package in.pwskills.nitin.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.pwskills.nitin.entity.Book;

@RestController
@RequestMapping("/v1/api/book")
public class BookRestController {
	
	/*
	 * METHOD : GET
	 * PATH   : /showA
	 * R.T    : ResponseEntity<String>
	 * INPUT  : no input
	 */
	
	@GetMapping("/showA")
	public ResponseEntity<String> showMsg1() {
		//return new ResponseEntity<String>("WELCOME",HttpStatus.OK);
		return ResponseEntity.ok("WELCOME TO FIRST CALL TYPE - GET");
	}
	
	/*
	 * METHOD : GET
	 * PATH   : /showB
	 * R.T    : ResponseEntity<String>
	 * INPUT  : {id}/{name}
	 */
	@GetMapping("/showB/{id}/{name}")
	public ResponseEntity<String> showMsg2(
			@PathVariable Integer id,
			@PathVariable  String name
	) 
	{
		return ResponseEntity.ok("WELCOME TO FIRST CALL TYPE - GET ==> " +id +"-"+name);
	}
	
	/*
	 * METHOD : GET
	 * PATH   : /showC
	 * R.T    : ResponseEntity<Book>
	 * INPUT  : {id}
	 */
	
	@GetMapping("/showC/{id}")
	public ResponseEntity<Book> showMsg3(
			@PathVariable Integer id
			) {
		return ResponseEntity.ok(new Book(id, "SBMS", "Shahid", 5000.0));
	}
	
	
	/*
	 * METHOD : POST
	 * PATH   : /showD
	 * R.T    : ResponseEntity<String>
	 * INPUT  : @RequestBody Book
	 */
	@PostMapping("/showD")
	public ResponseEntity<String> showMgs4(
			@RequestBody Book book
			) 
	{
		return ResponseEntity.ok("Data given is " + book);
	}
	
	/*
	 * METHOD : PUT
	 * PATH   : /showE
	 * R.T    : ResponseEntity<String>
	 * INPUT  : @RequestBody Book
	 */
	@PutMapping("/showE")
	public ResponseEntity<String> showMgs5(
			@RequestBody Book book
			) 
	{
		return ResponseEntity.ok("Data FROM PUT is " + book);
	}
	
	
	/*
	 * METHOD : DELETE
	 * PATH   : /showF
	 * R.T    : ResponseEntity<String>
	 * INPUT  : id(@PathVariable)
	 */
	@DeleteMapping("/showF/{id}")
	public ResponseEntity<String> showMsg6(
			@PathVariable  Integer id
			) 
	{
		return ResponseEntity.ok("DELETE MAPPING " + id);
	}


}
