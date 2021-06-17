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
public class PostingAlreadyExistsException extends ControllingException {

	/**
	 * Serial UID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor with posting number.
	 */
	public PostingAlreadyExistsException(String number) {
		super("Posting already exists: "+number);
	}

	/**
	 * Constructor with source reference.
	 */
	public PostingAlreadyExistsException(String source, String sourceReference, BigDecimal amount, String number1, String number2) {
		super("Posting already exists: src="+source+", ref="+sourceReference+", "+amount+": "+number1+" -> "+number2);
	}

}
