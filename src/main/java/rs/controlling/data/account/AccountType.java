package rs.controlling.data.account;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import rs.controlling.data.account.json.AccountTypeDeserializer;
import rs.controlling.data.account.json.AccountTypeSerializer;

/**
 * Is it aktiva or passiva account.
 * @author ralph
 *
 */
@JsonSerialize(using = AccountTypeSerializer.class)
@JsonDeserialize(using = AccountTypeDeserializer.class)
public enum AccountType {

	AKTIVA("A"),
	PASSIVA("P");
	
	private String typeId;
	
	private AccountType(String typeId) {
		this.typeId = typeId;
	}
	
	public String getTypeId() {
		return typeId;
	}
	
	public static AccountType get(String typeId) {
		for (AccountType c : AccountType.values()) {
			if (c.getTypeId().equals(typeId)) return c;
		}
		return null;
	}
	

}
