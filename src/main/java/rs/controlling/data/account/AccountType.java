package rs.controlling.data.account;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import rs.controlling.data.ControllingEnum;
import rs.controlling.data.account.json.AccountTypeDeserializer;
import rs.controlling.data.account.json.AccountTypeSerializer;

/**
 * Is it aktiva or passiva account.
 * @author ralph
 *
 */
@JsonSerialize(using = AccountTypeSerializer.class)
@JsonDeserialize(using = AccountTypeDeserializer.class)
public enum AccountType implements ControllingEnum {

	ASSETS("A", "Assets"),
	LIABILITIES("L", "Liabilities");
	
	private String typeId;
	private String description;
	
	private AccountType(String typeId, String description) {
		this.typeId = typeId;
		this.description = description;
	}
	
	public String getId() {
		return typeId;
	}
	
	public String getDescription() {
		return description;
	}
	
	public static AccountType get(String typeId) {
		for (AccountType c : AccountType.values()) {
			if (c.getId().equals(typeId)) return c;
		}
		return null;
	}
	

}
