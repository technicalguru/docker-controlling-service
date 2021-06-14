/**
 * 
 */
package rs.controlling.data.ledger;

/**
 * Type of a posting.
 * @author ralph
 *
 */
public enum PostingType {

	REDUCTION("R"),
	EXTENSION("E"),
	ASSET_SWAP("A"),
	DEBT_SWAP("P");
	
	private String typeId;
	
	private PostingType(String typeId) {
		this.typeId = typeId;
	}
	
	public String getTypeId() {
		return typeId;
	}
	
	public static PostingType get(String typeId) {
		for (PostingType c : PostingType.values()) {
			if (c.getTypeId().equals(typeId)) return c;
		}
		return null;
	}
	
	
}
