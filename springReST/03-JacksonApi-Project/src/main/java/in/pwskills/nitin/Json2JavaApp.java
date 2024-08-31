package in.pwskills.nitin;

import java.io.File;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import in.pwskills.nitin.bean.Person;

public class Json2JavaApp {
	public static void main(String[] args) throws Exception {

		// Use JACKSONAPI and convert java object to JSON
		ObjectMapper mapper = new ObjectMapper();
		mapper.enable(DeserializationFeature.UNWRAP_ROOT_VALUE);
		
		Person person = mapper.readValue(new File("src/main/resources/person.json"), Person.class);
		System.out.println(person);

	}
}
