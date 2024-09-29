package in.pwskills.nitin.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cart {

	private Integer cartId;
	private String cartCode;
	private Double cartCost;
}
