package in.pwskills.nitin.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import in.pwskills.nitin.request.PassengerInfo;
import in.pwskills.nitin.response.Ticket;

@Component
public class ERailTicketRunner implements CommandLineRunner {

	private String url = "http://localhost:9999/v1/api/railway/createTicket";
	
	@Override
	public void run(String... args) throws Exception {

		PassengerInfo body = new PassengerInfo();
		body.setFirstName("Ashish");
		body.setLastName("Gosh");
		body.setJourneyDate("21/09/2024");
		body.setFrom("Bengaluru");
		body.setTo("Delhi");
		body.setTrainNumber("Rajdhani");
		
		invokeSynchRestApi(body);
		
	}

	private void invokeSynchRestApi(PassengerInfo body) {
		//Creating a WebClient
		WebClient webClient = WebClient.create();
		
		System.out.println("***SynchRequest : WEBCLIENT Started ****");
		
		//Sending post request
		Ticket ticket = webClient
			.post()
			.uri(url)
			.body(BodyInserters.fromValue(body))
			.retrieve()
			.bodyToMono(Ticket.class)
			.block();
		
		System.out.println(ticket);
		System.out.println("***SynchRequest : WEBCLIENT Ended ****");
		
	}

}
