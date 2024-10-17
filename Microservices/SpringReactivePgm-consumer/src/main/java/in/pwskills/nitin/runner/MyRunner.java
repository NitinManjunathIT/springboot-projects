package in.pwskills.nitin.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;


@Component
public class MyRunner implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {

		String baseUrl = "http://localhost:9999/v1/api/student";
		/*
		 * Mono<Student> result = WebClient .create(baseUrl) .post() .uri("/create")
		 * .body(Mono.just(new Student("IND1", "rahul", 3500.0)),Student.class)
		 * .retrieve() .bodyToMono(Student.class);
		 * System.out.println("******FROM CONSUMER*****");
		 * result.subscribe(System.out::println);
		 * 
		 * System.out.println("**************************************************");
		 * System.out.println();
		 * 
		 * Flux<Student> flux = WebClient .create(baseUrl) .get() .uri("/findAll")
		 * .retrieve() .bodyToFlux(Student.class);
		 * 
		 * System.out.println("*****Flux Response**********");
		 * flux.doOnNext(System.out::println).blockLast();
		 * 
		 * 
		 * System.out.println("**************************************************");
		 * System.out.println();
		 * 
		 * Mono<Student> bodyToMono = WebClient .create(baseUrl) .get()
		 * .uri("/fetch/IND19") .retrieve() .bodyToMono(Student.class);
		 * 
		 * System.out.println("******FROM CONSUMER*****");
		 * bodyToMono.subscribe(System.out::println);
		 * 
		 * System.out.println("**************************************************");
		 * System.out.println();
		 */

		System.out.println("***Executing delete method call **********");
		WebClient
			.create(baseUrl)
			.method(HttpMethod.DELETE)
			.uri("/delete/IND19")
			.retrieve()
			.bodyToMono(Void.class);
	}

}
