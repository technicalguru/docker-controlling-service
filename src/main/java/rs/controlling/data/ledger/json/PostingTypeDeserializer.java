/**
 * 
 */
package rs.controlling.data.ledger.json;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import rs.controlling.data.ledger.PostingType;

/**
 * Unserializes PostingType
 * @author ralph
 */
public class PostingTypeDeserializer extends JsonDeserializer<PostingType> {

	@Override
	public PostingType deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
		return PostingType.get(p.getValueAsString());
	}


}
