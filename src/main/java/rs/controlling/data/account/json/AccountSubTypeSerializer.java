/**
 * 
 */
package rs.controlling.data.account.json;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import rs.controlling.data.account.AccountSubType;

/**
 * Serializes AccountSubType.
 * @author ralph
 */
public class AccountSubTypeSerializer extends JsonSerializer<AccountSubType> {

	@Override
	public void serialize(AccountSubType value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
		gen.writeString(value.getSubTypeId());		
	}

	
}
