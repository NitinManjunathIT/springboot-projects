package in.pwskills.nitin.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import in.pwskills.nitin.db.MessageStore;

@Component
public class ConsumerService {

	@Autowired
	private MessageStore store;

	@KafkaListener(topics = "${my.topic.name}", groupId = "SBMS")
	public void readData(String message) {
		// use message for internal usage

		System.out.println("****CONSUMER : READING DATA*******");
		System.out.println(message);

		
		// save the result in database
		store.add(message);

	}
}
