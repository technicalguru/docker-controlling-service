/**
 * 
 */
package rs.controlling.data.account;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import rs.controlling.data.ControllingEnum;
import rs.controlling.data.account.json.AccountSubTypeDeserializer;
import rs.controlling.data.account.json.AccountSubTypeSerializer;

/**
 * Purpose of the account 
 * @author ralph
 *
 */
@JsonSerialize(using = AccountSubTypeSerializer.class)
@JsonDeserialize(using = AccountSubTypeDeserializer.class)
public enum AccountSubType implements ControllingEnum {

	INVENTORY("I", "Inventory Account"),
	PROFIT_LOSS("P", "Profit/Loss Account"),
	OPENING("O", "Opening Account"),
	CLOSING("C", "Closing Account");
	
	private String subTypeId;
	private String description;
	
	private AccountSubType(String subTypeId, String description) {
		this.subTypeId = subTypeId;
		this.description = description;
	}
	
	public String getId() {
		return subTypeId;
	}
	
	public String getDescription() {
		return description;
	}
	
	public static AccountSubType get(String subTypeId) {
		for (AccountSubType c : AccountSubType.values()) {
			if (c.getId().equals(subTypeId)) return c;
		}
		return null;
	}
	

}
