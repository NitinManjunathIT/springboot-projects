package in.pwskills.nitin.bean;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {

	@JsonInclude(value = Include.NON_NULL)
	private Integer oid;

	@JsonInclude(value = Include.NON_EMPTY)
	private String name;

	private Boolean delivered;
	private String desc;

}
