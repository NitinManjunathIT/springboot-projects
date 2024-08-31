package in.pwskills.nitin.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
	private Integer bid;
	private String bname;
	private String bauth;
	private Double bcost;

}
