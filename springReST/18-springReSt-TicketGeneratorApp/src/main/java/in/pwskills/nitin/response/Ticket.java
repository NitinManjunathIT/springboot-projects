package in.pwskills.nitin.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ticket {
	private String from;
	private String journeyDate;
	private String passengerName;
	private String ticketId;
	private Double ticketPrice;
	private String ticketStatus;
	private String to;
	private String trainNumber;

}
