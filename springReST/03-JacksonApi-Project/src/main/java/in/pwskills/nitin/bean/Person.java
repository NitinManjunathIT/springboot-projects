package in.pwskills.nitin.bean;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import in.pwskills.nitin.deserialize.CustomDateDeSerialization;
import in.pwskills.nitin.serialize.CustomDateSerialization;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonPropertyOrder(value = { "orders", "firstName", "emailId" })
@JsonRootName("person")
@JsonIgnoreProperties(value = "emailId")
public class Person {

	@JsonProperty("first_name")
	private String firstName;

	@JsonProperty("last_name")
	private String lastName;

	
	private String emailId;

	@JsonSerialize(using = CustomDateSerialization.class)
	@JsonDeserialize(using = CustomDateDeSerialization.class)
	private Date dob;

	// HAS-A order:: multiple orders
	private List<Order> orders;

	// HAS-A account
	private Account account;

}
