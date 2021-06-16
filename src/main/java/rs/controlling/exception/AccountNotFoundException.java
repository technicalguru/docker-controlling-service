/**
 * 
 */
package rs.controlling.exception;

import rs.controlling.ControllingException;

/**
 * Exception for REST.
 * @author ralph
 *
 */
public class AccountNotFoundException extends ControllingException {

	/**
	 * Serial UID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor
	 */
	public AccountNotFoundException(String number) {
		super("No such account: "+number);
	}

}
