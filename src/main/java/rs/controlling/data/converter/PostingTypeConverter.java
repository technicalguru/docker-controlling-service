/**
 * 
 */
package rs.controlling.data.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import rs.controlling.data.ledger.PostingType;

/**
 * Convert the posting type back and to database.
 * @author ralph
 *
 */
@Converter
public class PostingTypeConverter implements AttributeConverter<PostingType, String> {

	@Override
	public String convertToDatabaseColumn(PostingType attribute) {
		return attribute.getId();
	}

	@Override
	public PostingType convertToEntityAttribute(String dbData) {
		return PostingType.get(dbData);
	}

	
}
