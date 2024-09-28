package in.pwskills.nitin.consumer;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class CartConsumer {

	@Autowired
	private LoadBalancerClient client;
	
	//Write a logic to consume the other service
	public String getCartService() {
		
		//ASK CLIENT TO GET THE INSTANCE WITH LOW LOAD FACTOR USING INSTANCE NAME
		ServiceInstance serviceInstance = client.choose("CART-SERVICE");
		
		//USING SERVICEINSTANCE GET THE URI
		URI uri = serviceInstance.getUri();
		
		//TAKE THE HELP OF URI AND CREATE URL
		String url = uri + "/v1/api/cart/show";
		
	
		RestTemplate rt = new RestTemplate();
		ResponseEntity<String> responseEntity = rt.getForEntity(url, String.class);
		
		
		return responseEntity.getBody();
	}
}
