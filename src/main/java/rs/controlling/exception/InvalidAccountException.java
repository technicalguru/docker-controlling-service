/**
 * 
 */
package rs.controlling.exception;

import rs.controlling.ControllingException;
import rs.controlling.data.account.AccountType;

/**
 * Exception for REST.
 * @author ralph
 *
 */
public class InvalidAccountException extends ControllingException {

	/**
	 * Serial UID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor
	 */
	public InvalidAccountException(String accountNumber, AccountType actual, AccountType expected) {
		super("Account "+accountNumber+": Invalid account type: "+actual+" (expected: "+expected+")");
	}
	
	/**
	 * Constructor
	 */
	public InvalidAccountException(String accountNumber) {
		super("Cannot use same account "+accountNumber+" for posting");
	}
}
