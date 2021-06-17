/**
 * 
 */
package rs.controlling.data.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import rs.controlling.data.ledger.AccountPostingType;

/**
 * Convert the account posting type back and to database.
 * @author ralph
 *
 */
@Converter
public class AccountPostingTypeConverter implements AttributeConverter<AccountPostingType, String> {

	@Override
	public String convertToDatabaseColumn(AccountPostingType attribute) {
		return attribute.getId();
	}

	@Override
	public AccountPostingType convertToEntityAttribute(String dbData) {
		return AccountPostingType.get(dbData);
	}

	
}
