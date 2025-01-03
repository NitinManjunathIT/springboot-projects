package in.pwskills.nitin.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="bookTab")
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer bid;
	private String bname;
	private String bauthor;
}
