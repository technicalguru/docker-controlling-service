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
public class PostingNotFoundException extends ControllingException {

	/**
	 * Serial UID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor
	 */
	public PostingNotFoundException(String number) {
		super("No such posting: "+number);
	}

}
