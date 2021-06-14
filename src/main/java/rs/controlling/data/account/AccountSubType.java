/**
 * 
 */
package rs.controlling.data.account;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import rs.controlling.data.account.json.AccountSubTypeDeserializer;
import rs.controlling.data.account.json.AccountSubTypeSerializer;

/**
 * Purpose of the account 
 * @author ralph
 *
 */
@JsonSerialize(using = AccountSubTypeSerializer.class)
@JsonDeserialize(using = AccountSubTypeDeserializer.class)
public enum AccountSubType {

	BALANCE("B"),
	PROFIT_LOSS("P"),
	OPENING("O"),
	CLOSING("C");
	
	private String subTypeId;
	
	private AccountSubType(String subTypeId) {
		this.subTypeId = subTypeId;
	}
	
	public String getSubTypeId() {
		return subTypeId;
	}
	
	public static AccountSubType get(String subTypeId) {
		for (AccountSubType c : AccountSubType.values()) {
			if (c.getSubTypeId().equals(subTypeId)) return c;
		}
		return null;
	}
	

}
