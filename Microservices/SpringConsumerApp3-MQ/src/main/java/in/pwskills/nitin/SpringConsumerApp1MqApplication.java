package in.pwskills.nitin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

@SpringBootApplication
@EnableJms
public class SpringConsumerApp1MqApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringConsumerApp1MqApplication.class, args);
	}

}
