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
public class IncompleteRequestException extends ControllingException {

	/**
	 * Serial UID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor with posting number.
	 */
	public IncompleteRequestException(String fieldName, Object actualValue) {
		super(actualValue != null ? "invalid field content: "+fieldName+"="+actualValue : fieldName+" must not be empty");
	}

}
