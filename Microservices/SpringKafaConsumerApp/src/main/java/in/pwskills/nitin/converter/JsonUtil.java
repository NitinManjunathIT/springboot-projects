package in.pwskills.nitin.converter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import in.pwskills.nitin.bean.StockApi;

public class JsonUtil {

	public static StockApi convertJsonToObject(String message) {
		
		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.readValue(message, StockApi.class);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
