package in.pwskills.nitin.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import in.pwskills.nitin.bean.MyErrorResponse;
import in.pwskills.nitin.bean.ProductNotFoundException;

@RestControllerAdvice
public class MyCustomExceptionHandler {
	
	static {
		System.out.println("MyCustomExceptionHandler.class file is loading..()");
	}
	
	public MyCustomExceptionHandler() {
		System.out.println("MyCustomExceptionHandler object is created..");
	}
	
	/*
	 * 
	 * 
		@ExceptionHandler(value = ProductNotFoundException.class)
		public ResponseEntity<String> showCustomErrorMsg(
				ProductNotFoundException pnfe
				){
		System.out.println("MyCustomExceptionHandler.showCustomErrorMsg()");
			return new ResponseEntity<>(pnfe.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	 * 
	 */
	
	@ExceptionHandler(value = ProductNotFoundException.class)
	public ResponseEntity<MyErrorResponse> showCustomErrorMsg(
				ProductNotFoundException pnfe
	){
		
		MyErrorResponse body = new MyErrorResponse(
				new Date().toString(), 
				"PRODUCT NOT FOUND", 
				404, 
				pnfe.getMessage());
		
		return new ResponseEntity<>(body, HttpStatus.INTERNAL_SERVER_ERROR);		
	}	
}
