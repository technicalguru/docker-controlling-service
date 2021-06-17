/**
 * 
 */
package rs.controlling.data.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import rs.controlling.data.account.AccountSubType;

/**
 * Convert the account sub type back and to database.
 * @author ralph
 *
 */
@Converter
public class AccountSubTypeConverter implements AttributeConverter<AccountSubType, String> {

	@Override
	public String convertToDatabaseColumn(AccountSubType attribute) {
		return attribute.getId();
	}

	@Override
	public AccountSubType convertToEntityAttribute(String dbData) {
		return AccountSubType.get(dbData);
	}

	
}
