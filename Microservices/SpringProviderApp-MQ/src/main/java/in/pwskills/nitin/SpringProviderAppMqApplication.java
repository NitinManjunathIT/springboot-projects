package in.pwskills.nitin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SpringProviderAppMqApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringProviderAppMqApplication.class, args);
	}
}
