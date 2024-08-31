package com.app.nitin.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.app.nitin.entity.Book;

@Component
public class GetRunner implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {

		final String URL1 = "http://localhost:9999/v1/api/book/showA";
		final String URL2 = "http://localhost:9999/v1/api/book/showB/10/Microservices";
		final String URL3 = "http://localhost:9999/v1/api/book/showC/{id}";

		// Creation of RestTemplate object
		RestTemplate template = new RestTemplate();

		// send the request to the URL
		ResponseEntity<String> response1 = template.getForEntity(URL1, String.class);
		ResponseEntity<String> response2 = template.getForEntity(URL2, String.class);

		// Reading the response details from the object
		System.out.println(response1.getBody());
		System.out.println(response1.getHeaders());
		System.out.println(response1.getStatusCode().value());

		System.out.println("**********************************************");

		// Reading the response details from the object
		System.out.println(response2.getBody());
		System.out.println(response2.getHeaders());
		System.out.println(response2.getStatusCode().value());

		System.out.println("**********************************************");
		
		ResponseEntity<Book> response3 = template.getForEntity(
					URL3,  //URL details
					Book.class, //ResponseEntity 
					25); //Path Variable
		// Reading the response details from the object
		System.out.println(response3.getBody());
		System.out.println(response3.getHeaders());
		System.out.println(response3.getStatusCode().value());

	}

}
