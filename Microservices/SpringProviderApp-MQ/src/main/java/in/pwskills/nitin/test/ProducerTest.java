package in.pwskills.nitin.test;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import in.pwskills.nitin.service.ProducerService;

@Component
public class ProducerTest {

	@Autowired
	private ProducerService service;
	
	
	@Scheduled(cron="*/10 * * * * *")
	public void sendMessage() {
		service.sendData("HELLO :: "+new Date());
		System.out.println("PRODUCER SENT MESSAGE....");
	}
	
}
