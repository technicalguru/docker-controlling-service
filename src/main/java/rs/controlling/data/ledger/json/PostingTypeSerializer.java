/**
 * 
 */
package rs.controlling.data.ledger.json;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import rs.controlling.data.ledger.PostingType;

/**
 * Serializes PostingType.
 * @author ralph
 */
public class PostingTypeSerializer extends JsonSerializer<PostingType> {

	@Override
	public void serialize(PostingType value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
		gen.writeString(value.getId());		
	}

	
}
