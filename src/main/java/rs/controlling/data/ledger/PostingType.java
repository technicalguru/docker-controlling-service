/**
 * 
 */
package rs.controlling.data.ledger;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import rs.controlling.data.ControllingEnum;
import rs.controlling.data.ledger.json.PostingTypeDeserializer;
import rs.controlling.data.ledger.json.PostingTypeSerializer;

/**
 * Type of a posting.
 * @author ralph
 *
 */
@JsonSerialize(using = PostingTypeSerializer.class)
@JsonDeserialize(using = PostingTypeDeserializer.class)
public enum PostingType implements ControllingEnum {

	REDUCTION("R", "Reduction of balance sheet"),
	EXTENSION("E", "Extension of balance sheet"),
	ASSET_SWAP("A", "Asset swap"),
	LIABILITY_SWAP("L", "Liability swap");
	
	private String typeId;
	private String description;
	
	private PostingType(String typeId, String description) {
		this.typeId = typeId;
		this.description = description;
	}
	
	public String getId() {
		return typeId;
	}
	
	public String getDescription() {
		return description;
	}
	
	public static PostingType get(String typeId) {
		for (PostingType c : PostingType.values()) {
			if (c.getId().equals(typeId)) return c;
		}
		return null;
	}
	
	
}
