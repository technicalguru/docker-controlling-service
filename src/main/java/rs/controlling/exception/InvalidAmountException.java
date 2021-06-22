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
public class InvalidAmountException extends ControllingException {

	/**
	 * Serial UID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor
	 */
	public InvalidAmountException(BigDecimal amount) {
		super("Invalid amount: "+amount);
	}

}
