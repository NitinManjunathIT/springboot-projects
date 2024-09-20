package in.pwskills.nitin.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import in.pwskills.nitin.request.PassengerInfo;
import in.pwskills.nitin.response.Ticket;

@Component
public class ERailClient implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {

		//REQUEST URL
		String REST_ENDPOINT_URL="http://localhost:8888/v1/api/railway/createTicket";
		
		// Sending the request object[Passenger object]
		PassengerInfo pinfo = new PassengerInfo();
		pinfo.setFirstName("virat");
		pinfo.setLastName("kohli");
		pinfo.setJourneyDate("23-SEP-2024");
		pinfo.setFrom("BENGALURU");
		pinfo.setTo("DELHI");
		pinfo.setTrainNumber("KKExpress-123");

		// Creating the header object for holding details
		HttpHeaders headers = new HttpHeaders();
		headers.add("Accept", "application/json");
		headers.add("Content-Type", "application/json");

		// Creating an entity object to send the request
		HttpEntity<PassengerInfo> reqEntity = new HttpEntity<>(pinfo, headers);

		// Creating a RestTemplate object
		RestTemplate rt = new RestTemplate();

		System.out.println("*********SENDING THE REQUEST **************");
		
		// Sending the request
		ResponseEntity<Ticket> ticketEntity = rt.exchange(
						REST_ENDPOINT_URL, 
						HttpMethod.POST, 
						reqEntity, 
						Ticket.class);

		System.out.println("*********GETTING THE RESPONSE **************");
		System.out.println(ticketEntity.getStatusCode().value());

		// getting the response object[Ticket object]
		System.out.println(ticketEntity.getBody());

	}

}
