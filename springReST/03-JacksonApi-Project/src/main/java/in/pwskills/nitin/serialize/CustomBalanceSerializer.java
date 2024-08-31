package in.pwskills.nitin.serialize;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.DecimalFormat;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class CustomBalanceSerializer extends JsonSerializer<BigDecimal> {
	@Override
	public void serialize(BigDecimal balance, JsonGenerator gen, SerializerProvider serializers) throws IOException {
		//logic for serialization
		DecimalFormat formatter = new DecimalFormat("#0.00");
		gen.writeString(formatter.format(balance));
	}
}
