/**
 * 
 */
package rs.controlling.data.ledger;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import rs.controlling.data.ledger.json.AccountPostingTypeDeserializer;
import rs.controlling.data.ledger.json.AccountPostingTypeSerializer;


/**
 * Type of an account posting.
 * @author ralph
 *
 */
@JsonSerialize(using = AccountPostingTypeSerializer.class)
@JsonDeserialize(using = AccountPostingTypeDeserializer.class)
public enum AccountPostingType {

	DEBIT("S"),
	CREDIT("H");
	
	private String typeId;
	
	private AccountPostingType(String typeId) {
		this.typeId = typeId;
	}
	
	public String getTypeId() {
		return typeId;
	}
	
	public static AccountPostingType get(String typeId) {
		for (AccountPostingType c : AccountPostingType.values()) {
			if (c.getTypeId().equals(typeId)) return c;
		}
		return null;
	}
	
	
}
