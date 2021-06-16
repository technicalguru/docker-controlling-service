/**
 * 
 */
package rs.controlling.data.ledger.json;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import rs.controlling.data.ledger.AccountPostingType;

/**
 * Serializes AccountPostingType.
 * @author ralph
 */
public class AccountPostingTypeSerializer extends JsonSerializer<AccountPostingType> {

	@Override
	public void serialize(AccountPostingType value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
		gen.writeString(value.getId());		
	}

	
}
