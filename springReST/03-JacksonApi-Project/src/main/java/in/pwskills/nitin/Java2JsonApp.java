package in.pwskills.nitin;

import java.io.File;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import in.pwskills.nitin.bean.Account;
import in.pwskills.nitin.bean.Order;
import in.pwskills.nitin.bean.Person;

public class Java2JsonApp {
	public static void main(String[] args) throws Exception {

		Order ord1 = new Order(1234, "laptop", true, "good");
		Order ord2 = new Order(null, "mobile", false, "good");
		Order ord3 = new Order(2323, "", true, "good");

		Account account = new Account("123452435", "HDFC", new BigDecimal(12234));

		Person person = new Person("sachin", "tendulkar", "sachin@gmail.com", new Date(), List.of(ord1, ord2, ord3),
				account);

		// Use JACKSONAPI and convert java object to JSON
		ObjectMapper mapper = new ObjectMapper();
		mapper.enable(SerializationFeature.INDENT_OUTPUT);
		mapper.enable(SerializationFeature.WRAP_ROOT_VALUE);

		mapper.setSerializationInclusion(Include.NON_NULL);
		mapper.setSerializationInclusion(Include.NON_EMPTY);

		String personAsString = mapper.writeValueAsString(person);
		System.out.println(personAsString);

		mapper.writerWithDefaultPrettyPrinter().writeValue(new File("src/main/resources/person.json"), person);
		System.out.println("Serialization is completed...");

	}
}
