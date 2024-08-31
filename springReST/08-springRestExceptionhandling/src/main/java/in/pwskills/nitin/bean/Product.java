package in.pwskills.nitin.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class Product {
	private Integer pid;
	private String pname;
	private Double pcost;
}
