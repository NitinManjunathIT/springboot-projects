package in.pwskills.nitin.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.pwskills.nitin.request.PassengerInfo;
import in.pwskills.nitin.response.Ticket;

@RestController
@RequestMapping("/v1/api/railway")
public class ERailResource {

	/*
	 * METHOD : POST
	 * INPUT  : PassengerDetails (@RequestBody)
	 * OUTPUT : Ticket(JSON)
	 * URL    : /createTicket
	 * 
	 */
	@PostMapping("/createTicket")
	public ResponseEntity<Ticket> bookTicket(
			@RequestBody PassengerInfo pinfo
			)
	{
		//Creating a ticket object
		Ticket body = new Ticket();
		
		//Setting the ticket object data
		body.setTicketId("TA02899");
		body.setTicketStatus("CONFIRMED");
		body.setJourneyDate(pinfo.getJourneyDate());
		body.setPassengerName(pinfo.getFirstName() + " " + pinfo.getLastName());
		body.setTrainNumber(pinfo.getTrainNumber());
		body.setTicketPrice(350.00);
		body.setFrom(pinfo.getFrom());
		body.setTo(pinfo.getTo());
		
		try {
			//sleeping for 30sec
			Thread.sleep(30000);
		}catch(Exception e) {
			
		}
		
		return new ResponseEntity<Ticket>(body, HttpStatus.CREATED);
	}	
}








