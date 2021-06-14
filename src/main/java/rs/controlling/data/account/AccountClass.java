/**
 * 
 */
package rs.controlling.data.account;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import rs.controlling.data.account.json.AccountClassDeserializer;
import rs.controlling.data.account.json.AccountClassSerializer;

/**
 * Account Class according German SKR03.
 * @author ralph
 *
 */
@JsonSerialize(using = AccountClassSerializer.class)
@JsonDeserialize(using = AccountClassDeserializer.class)
public enum AccountClass {

	INVESTMENT_AND_CAPITAL("0"),
	CASH_AND_PRIVATE("1"),
	ACCRUAL("2"),
	STOCK_AND_GOOD_RECEIPT("3"),
	OPERATING_EXPENSES("4"),
	OTHER_OPERATING_EXPENSES("5"),
	PROFIT_AND_LOSS("6"),
	STOCKS("7"),
	SALES("8"),
	CARRY_FORWARD_AND_ADJUSTMENT("9");
	
	private String classNumber;
	
	private AccountClass(String classNumber) {
		this.classNumber = classNumber;
	}
	
	public String getClassNumber() {
		return classNumber;
	}
	
	public static AccountClass get(String classNumber) {
		for (AccountClass c : AccountClass.values()) {
			if (c.getClassNumber().equals(classNumber)) return c;
		}
		return null;
	}
	
}
