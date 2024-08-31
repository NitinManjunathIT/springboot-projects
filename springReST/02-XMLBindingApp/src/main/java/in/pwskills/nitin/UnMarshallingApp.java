package in.pwskills.nitin;

import java.io.File;

import in.pwskills.nitin.bean.Person;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;

public class UnMarshallingApp {
	public static void main(String[] args) throws JAXBException {

		// Read XML data and convert to object
		JAXBContext context = JAXBContext.newInstance(Person.class);

		Unmarshaller unmarshaller = context.createUnmarshaller();

		Person person = (Person) unmarshaller.unmarshal(new File("src/main/resources/person.xml"));
		System.out.println(person);

	}
}
