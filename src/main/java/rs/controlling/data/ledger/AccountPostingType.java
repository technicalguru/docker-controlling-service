/**
 * 
 */
package rs.controlling.data.ledger;

/**
 * Type of an account posting.
 * @author ralph
 *
 */
public enum AccountPostingType {

	DEBIT("H"),
	CREDIT("S");
	
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
