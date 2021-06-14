package rs.controlling.data.account;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import rs.controlling.data.account.json.AccountGroupDeserializer;
import rs.controlling.data.account.json.AccountGroupSerializer;

/**
 * Sub Group in a account class.
 * @author ralph
 *
 */
@JsonSerialize(using = AccountGroupSerializer.class)
@JsonDeserialize(using = AccountGroupDeserializer.class)
public enum AccountGroup {

	GROUP_0("0"),
	GROUP_1("1"),
	GROUP_2("2"),
	GROUP_3("3"),
	GROUP_4("4"),
	GROUP_5("5"),
	GROUP_6("6"),
	GROUP_7("7"),
	GROUP_8("8"),
	GROUP_9("9");
	
	private String groupNumber;
	
	private AccountGroup(String groupNumber) {
		this.groupNumber = groupNumber;
	}
	
	public String getGroupNumber() {
		return groupNumber;
	}
	
	public static AccountGroup get(String groupNumber) {
		for (AccountGroup c : AccountGroup.values()) {
			if (c.getGroupNumber().equals(groupNumber)) return c;
		}
		return null;
	}
	

}
