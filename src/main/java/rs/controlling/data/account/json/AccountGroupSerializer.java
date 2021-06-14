/**
 * 
 */
package rs.controlling.data.account.json;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import rs.controlling.data.account.AccountGroup;

/**
 * Serializes AccountGroup.
 * @author ralph
 */
public class AccountGroupSerializer extends JsonSerializer<AccountGroup> {

	@Override
	public void serialize(AccountGroup value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
		gen.writeString(value.getGroupNumber());		
	}

	
}
