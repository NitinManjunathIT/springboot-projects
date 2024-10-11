package in.pwskills.nitin.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.pwskills.nitin.bean.StockApi;
import in.pwskills.nitin.db.MessageStore;

@RestController
@RequestMapping("/v1/api/stock")
public class StockRestController {

	@Autowired
	private MessageStore store;
	
	/*
	 * METHOD : GET
	 * PATH   : /all
	 * INPUT  : noinput
	 * R.T    : List<StockApi>
	 */
	
	@GetMapping("/all")
	public List<StockApi> findAllStocks(){
		return store.getAll();
	}	
}
