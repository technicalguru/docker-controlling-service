/**
 * 
 */
package rs.controlling.data.ledger;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import rs.controlling.data.ledger.json.PostingTypeDeserializer;
import rs.controlling.data.ledger.json.PostingTypeSerializer;

/**
 * Type of a posting.
 * @author ralph
 *
 */
@JsonSerialize(using = PostingTypeSerializer.class)
@JsonDeserialize(using = PostingTypeDeserializer.class)
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
