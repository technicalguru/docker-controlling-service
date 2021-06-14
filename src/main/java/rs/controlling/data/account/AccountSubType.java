/**
 * 
 */
package rs.controlling.data.account;

/**
 * Purpose of the account 
 * @author ralph
 *
 */
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
