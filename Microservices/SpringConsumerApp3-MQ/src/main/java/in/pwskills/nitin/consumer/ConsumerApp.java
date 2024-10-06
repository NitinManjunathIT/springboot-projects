package in.pwskills.nitin.consumer;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class ConsumerApp {

	@JmsListener(destination = "${my.app.desti-name}")
	public void readData(String data) {
		System.out.println("Consumer#3 :: "+data);
	}	
}
