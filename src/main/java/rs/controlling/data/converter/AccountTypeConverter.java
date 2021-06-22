/**
 * 
 */
package rs.controlling.data.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import rs.controlling.data.account.AccountType;

/**
 * Convert the account type back and to database.
 * @author ralph
 *
 */
@Converter
public class AccountTypeConverter implements AttributeConverter<AccountType, String> {

	@Override
	public String convertToDatabaseColumn(AccountType attribute) {
		return attribute.getId();
	}

	@Override
	public AccountType convertToEntityAttribute(String dbData) {
		return AccountType.get(dbData);
	}

	
}
