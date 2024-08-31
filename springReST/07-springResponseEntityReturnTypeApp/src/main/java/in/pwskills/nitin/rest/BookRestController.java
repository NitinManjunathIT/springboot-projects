package in.pwskills.nitin.rest;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.pwskills.nitin.bean.Book;

@RestController
@RequestMapping("/v1/api/book")
public class BookRestController {
	
	/*
	 * R.T    : ResponseEntity<?>
	 * Method : GET
	 * PATH   : /find/{id}
	 * Input  : id (@PathVariable)
	 */
	
	@GetMapping("/find/{id}")
	public ResponseEntity<?> getBookDetails(
		@PathVariable Integer id) {
		
		HttpHeaders headers ;
		if (id==5) {
			headers = new HttpHeaders();
			headers.add("found", "yes");
			return new ResponseEntity<Book>(new Book(5,"MICROSERVICES",5000.0), headers, HttpStatus.OK);
		} else {
			headers = new HttpHeaders();
			headers.add("found", "no");
			return new ResponseEntity<String>("SORRY BOOK NOT FOUND", headers, HttpStatus.BAD_REQUEST);
		}	
	}
	
	
	/*
	 * R.T    : Book
	 * Method : GET
	 * PATH   : /info
	 * Input  : no input
	 */
	@GetMapping("/info")
	public Book getBookInfo() {
		// return new ResponseEntity(Book,HttpStatus.OK);
		return new Book(10,"HIBERNATE",6000.0); 
	}
	
	
}
