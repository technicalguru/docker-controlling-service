/**
 * 
 */
package rs.controlling.data.ledger.json;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import rs.controlling.data.ledger.AccountPostingType;

/**
 * Unserializes AccountPostingType
 * @author ralph
 */
public class AccountPostingTypeDeserializer extends JsonDeserializer<AccountPostingType> {

	@Override
	public AccountPostingType deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
		return AccountPostingType.get(p.getValueAsString());
	}


}
