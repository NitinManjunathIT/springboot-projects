package in.pwskills.nitin.deserialize;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class CustomDateDeSerialization extends JsonDeserializer<Date> {

	@Override
	public Date deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JacksonException {
		// logic for DeSerialization
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
		String date = p.getText();
		Date output = null;
		try {
			output = formatter.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return output;

	}

}
