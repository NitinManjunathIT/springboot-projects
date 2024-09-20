package in.pwskills.nitin.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import in.pwskills.nitin.response.CurrencyResponse;

@Component
public class CurrencyRunner implements CommandLineRunner {

	private String url = "http://localhost:9999/v1/api/currency/convertFromUSDToINR/from/{from}/to/{to}";

	@Override
	public void run(String... args) throws Exception {

		invokeRestApiASync("USD", "INR");
	}

	private void invokeRestApiASync(String from, String to) {
		// Working with WebClient
		WebClient webClient = WebClient.create();

		System.out.println("***WebClient: ASynchRequest Started***");
		
		//Sending Get request in ASynchronous request
		webClient.get()
				 .uri(url, from,to)
				 .retrieve()
				 .bodyToMono(CurrencyResponse.class)
				 .subscribe(CurrencyRunner::consumeInput);
		
		System.out.println("***WebClient: ASynchRequest Ended***");

	}
	
	public static void consumeInput(CurrencyResponse response) {
		System.out.println(response);
		//use this response and send it to other MS using MQ(Apache kafka)
	}

	@SuppressWarnings("unused")
	private void invokeRestApiSync(String from, String to) {
		// Working with WebClient
		WebClient webClient = WebClient.create();

		System.out.println("***WebClient: SynchRequest Started***");

		// Request type is get
		CurrencyResponse currencyResponse = webClient.get().uri(url, from, to).retrieve()
				.bodyToMono(CurrencyResponse.class).block();

		System.out.println("***WebClient: SynchRequest Ended***");
		System.out.println(currencyResponse);

	}

}
