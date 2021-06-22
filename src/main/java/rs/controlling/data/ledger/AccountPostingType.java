/**
 * 
 */
package rs.controlling.data.ledger;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import rs.controlling.data.ControllingEnum;
import rs.controlling.data.ledger.json.AccountPostingTypeDeserializer;
import rs.controlling.data.ledger.json.AccountPostingTypeSerializer;


/**
 * Type of an account posting.
 * @author ralph
 *
 */
@JsonSerialize(using = AccountPostingTypeSerializer.class)
@JsonDeserialize(using = AccountPostingTypeDeserializer.class)
public enum AccountPostingType implements ControllingEnum {

	DEBIT("S", "Debiting posting (Soll)"),
	CREDIT("H", "Crediting posting (Haben)");
	
	private String typeId;
	private String description;
	
	private AccountPostingType(String typeId, String description) {
		this.typeId = typeId;
		this.description = description;
	}
	
	public String getId() {
		return typeId;
	}
	
	public String getDescription() {
		return description;
	}
	
	public static AccountPostingType get(String typeId) {
		for (AccountPostingType c : AccountPostingType.values()) {
			if (c.getId().equals(typeId)) return c;
		}
		return null;
	}
	
	
}
