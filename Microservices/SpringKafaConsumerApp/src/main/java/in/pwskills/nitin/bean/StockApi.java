package in.pwskills.nitin.bean;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="STOCKTAB")
public class StockApi {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer stkId;
	private String stkCode;
	private Double stkCost;

}
