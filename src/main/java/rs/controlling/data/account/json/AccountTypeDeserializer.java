/**
 * 
 */
package rs.controlling.data.account.json;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import rs.controlling.data.account.AccountType;

/**
 * Unserializes AccountType
 * @author ralph
 */
public class AccountTypeDeserializer extends JsonDeserializer<AccountType> {

	@Override
	public AccountType deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
		return AccountType.get(p.getValueAsString());
	}


}
