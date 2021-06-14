/**
 * 
 */
package rs.controlling.data.ledger;

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
	public PostingNotFoundException(Long uid) {
		super("No such posting: "+uid);
	}

}
