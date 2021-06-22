/**
 * 
 */
package rs.controlling.data.account.json;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import rs.controlling.data.account.AccountSubType;

/**
 * Unserializes AccountSubType
 * @author ralph
 */
public class AccountSubTypeDeserializer extends JsonDeserializer<AccountSubType> {

	@Override
	public AccountSubType deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
		return AccountSubType.get(p.getValueAsString());
	}


}
