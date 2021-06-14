/**
 * 
 */
package rs.controlling.data.account;

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
	public AccountNotFoundException(Long uid) {
		super("No such account: "+uid);
	}

}
