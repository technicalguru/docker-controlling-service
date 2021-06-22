/**
 * 
 */
package rs.controlling.data.account.json;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import rs.controlling.data.account.AccountClass;

/**
 * Serializes AccountClass.
 * @author ralph
 */
public class AccountClassSerializer extends JsonSerializer<AccountClass> {

	@Override
	public void serialize(AccountClass value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
		gen.writeString(value.getId());		
	}

	
}
