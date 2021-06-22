/**
 * 
 */
package rs.controlling.data.account.json;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import rs.controlling.data.account.AccountType;

/**
 * Serializes AccountType.
 * @author ralph
 */
public class AccountTypeSerializer extends JsonSerializer<AccountType> {

	@Override
	public void serialize(AccountType value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
		gen.writeString(value.getId());		
	}

	
}
