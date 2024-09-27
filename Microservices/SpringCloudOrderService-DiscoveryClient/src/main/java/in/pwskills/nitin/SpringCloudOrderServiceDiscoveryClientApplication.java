package in.pwskills.nitin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SpringCloudOrderServiceDiscoveryClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudOrderServiceDiscoveryClientApplication.class, args);
	}

}
