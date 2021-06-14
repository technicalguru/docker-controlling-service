/**
 * 
 */
package rs.controlling.data;

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
	
	private AccountSubType(String subTypeId) {
		
	}
}
