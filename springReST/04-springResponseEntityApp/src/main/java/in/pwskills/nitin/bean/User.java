package in.pwskills.nitin.bean;

import java.util.Map;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonPropertyOrder(value = {"userId","userRole"})
public class User {
	@JsonProperty("user_id")
	private Integer userId;
	
	@JsonProperty("user_name")
	private String userName;
	private String userRole;
	
	@JsonIgnore
	private String password;
	
	private Set<String> friendsName;
	
	private Map<String,Long> accountDetails;
	
}
