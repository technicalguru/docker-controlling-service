package rs.controlling.data.account;

/**
 * Is it aktiva or passiva account.
 * @author ralph
 *
 */
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
