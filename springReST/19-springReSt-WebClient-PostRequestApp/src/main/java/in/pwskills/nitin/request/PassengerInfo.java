package in.pwskills.nitin.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PassengerInfo {
	private String firstName;
	private String from;
	private String journeyDate;
	private String lastName;
	private String to;
	private String trainNumber;
}
