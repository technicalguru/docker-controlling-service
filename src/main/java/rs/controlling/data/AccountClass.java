/**
 * 
 */
package rs.controlling.data;

/**
 * Account Class according German SKR03.
 * @author ralph
 *
 */
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
	
	private AccountClass(String classNumber) {
		
	}
}
