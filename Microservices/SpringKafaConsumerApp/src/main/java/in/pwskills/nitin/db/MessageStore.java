package in.pwskills.nitin.db;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import in.pwskills.nitin.bean.StockApi;
import in.pwskills.nitin.converter.JsonUtil;
import in.pwskills.nitin.repository.IStockRepository;

@Component
public class MessageStore {

	@Autowired
	private IStockRepository repo;
	
	public void add(String message) {
		//JSON TO Object
		StockApi si = JsonUtil.convertJsonToObject(message);
		repo.save(si);
	}

	public List<StockApi> getAll() {
		return repo.findAll();
	}	
}
