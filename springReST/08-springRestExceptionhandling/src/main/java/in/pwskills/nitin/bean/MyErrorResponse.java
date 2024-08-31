package in.pwskills.nitin.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MyErrorResponse {
	private String date;
	private String status;
	private int code;
	private String message;

}
