package in.pwskills.nitin;

import java.io.File;

import in.pwskills.nitin.bean.Address;
import in.pwskills.nitin.bean.Person;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Marshaller;

public class MarshallingApp {
	public static void main(String[] args) throws Exception {

		Person person = new Person();

		person.setId(10);
		person.setEmail("sachin@gmail.com");
		person.setGender("male");
		person.setName("sachin");

		Address address = new Address();
		address.setCity("bandra");
		address.setState("Maharshtra");
		address.setCountry("IND");

		person.setAddress(address);

		JAXBContext context = JAXBContext.newInstance(Person.class);
		Marshaller marshaller = context.createMarshaller();
		marshaller.marshal(person, new File("src/main/resources/person.xml"));
		System.out.println("********Marshalling Completed**********");
	}
}
