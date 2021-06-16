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
public class AccountExistsException extends ControllingException {

	/**
	 * Serial UID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor
	 */
	public AccountExistsException(String number) {
		super("Account already exists: "+number);
	}

}
