package in.pwskills.nitin.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import in.pwskills.nitin.bean.StockApi;
import in.pwskills.nitin.converter.JsonUtil;
import in.pwskills.nitin.producer.ProducerService;

@RestController
@RequestMapping("/v1/api/stock")
public class StockRestController {

	@Autowired
	private ProducerService service;
	
	
	/***
	 * METHOD : GET
	 * INPUT  : code,cost(@RequestParam)
	 * OUTPUT : String
	 * path   : /send
	 */
	@GetMapping("/send")
	public String readInput(
			 @RequestParam  Double cost,
			 @RequestParam  String code
			) {
	
		//Create an object holding cost and code
		StockApi api = new StockApi();
		api.setStkCode(code);
		api.setStkCost(cost);
		
		//Convert object to jsonString format and send it to Service
		String message = JsonUtil.convertObjectToJson(api);
		
		if (message != null) {
			service.sendMessage(message);
			return "SUCCESS";
			
		}else {
			return "FAILURE";
		}
	}
}
