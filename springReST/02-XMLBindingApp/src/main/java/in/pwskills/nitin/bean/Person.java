package in.pwskills.nitin.bean;

import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Data;

@Data
@XmlRootElement
public class Person {

	private Integer id;

	private String name;
	private String email;
	private String gender;
	
	private Address address;

}
