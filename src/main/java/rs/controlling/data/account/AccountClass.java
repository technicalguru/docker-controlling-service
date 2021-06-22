/**
 * 
 */
package rs.controlling.data.account;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import rs.controlling.data.ControllingEnum;
import rs.controlling.data.account.json.AccountClassDeserializer;
import rs.controlling.data.account.json.AccountClassSerializer;

/**
 * Account Class according German SKR03.
 * @author ralph
 *
 */
@JsonSerialize(using = AccountClassSerializer.class)
@JsonDeserialize(using = AccountClassDeserializer.class)
public enum AccountClass implements ControllingEnum {

	INVESTMENT_AND_CAPITAL("0", "Investment and capita accounts (Asset account)"),
	CASH_AND_PRIVATE("1", "Cash and private accounts (Asset account)"),
	ACCRUAL("2", "Accrual accounts (Asset account)"),
	STOCK_AND_GOODS_RECEIPT("3", "Stock accounts and goods receipt accounts (Liability account)"),
	OPERATING_EXPENSES("4", "Operating expenses account (Liability account)"),
	OTHER_OPERATING_EXPENSES("5", "Account for other operational expenses (Liability account)"),
	PROFIT_AND_LOSS("6", "Profit and loss accounts (Liability account)"),
	STOCKS("7", "Stocks account (Liability account)"),
	SALES("8", "Sales account (Liability account)"),
	CARRY_FORWARD_AND_ADJUSTMENT("9", " (Liability account)");
	
	private String classNumber;
	private String description;
	
	private AccountClass(String classNumber, String description) {
		this.classNumber = classNumber;
		this.description = description;
	}
	
	public String getId() {
		return classNumber;
	}
	
	public String getDescription() {
		return description;
	}
	
	public static AccountClass get(String classNumber) {
		for (AccountClass c : AccountClass.values()) {
			if (c.getId().equals(classNumber)) return c;
		}
		return null;
	}
	
}
