/**
 * 
 */
package rs.controlling.data.account.json;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import rs.controlling.data.account.AccountGroup;

/**
 * Unserializes AccountGroup
 * @author ralph
 */
public class AccountGroupDeserializer extends JsonDeserializer<AccountGroup> {

	@Override
	public AccountGroup deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
		return AccountGroup.get(p.getValueAsString());
	}


}
