package in.pwskills.nitin.bean;

import java.util.List;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
	private Integer empId;
	private String empName;
	private Double empSal;
	
	private Address address;
	private List<String> friendNames;
	private Map<String,Long> accountDetails;
	
}
