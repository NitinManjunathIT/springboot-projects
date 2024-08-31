package in.pwskills.nitin.serialize;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class CustomDateSerialization extends JsonSerializer<Date> {
	@Override
	public void serialize(Date date, JsonGenerator gen, SerializerProvider serializers) throws IOException {
		//write a logic for serialization
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
		gen.writeString(formatter.format(date));
	}
}
