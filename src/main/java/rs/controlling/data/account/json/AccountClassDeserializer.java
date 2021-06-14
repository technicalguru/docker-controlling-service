/**
 * 
 */
package rs.controlling.data.account.json;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import rs.controlling.data.account.AccountClass;

/**
 * Unserializes AccountClass
 * @author ralph
 */
public class AccountClassDeserializer extends JsonDeserializer<AccountClass> {

	@Override
	public AccountClass deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
		return AccountClass.get(p.getValueAsString());
	}


}
