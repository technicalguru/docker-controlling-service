/**
 * 
 */
package rs.controlling.exception;

import java.math.BigDecimal;

import rs.controlling.ControllingException;

/**
 * Exception for REST.
 * @author ralph
 *
 */
public class AccountNotEmptyException extends ControllingException {

	/**
	 * Serial UID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor
	 */
	public AccountNotEmptyException(String number, BigDecimal balance) {
		super("Account "+number+" not empty: "+balance);
	}

}
