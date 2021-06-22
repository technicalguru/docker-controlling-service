/**
 * 
 */
package rs.controlling;

/**
 * @author ralph
 *
 */
public class ControllingException extends RuntimeException {

	/**
	 * Serial ID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor.
	 */
	public ControllingException() {
	}

	/**
	 * Constructor.
	 * @param message
	 */
	public ControllingException(String message) {
		super(message);
	}

	/**
	 * Constructor.
	 * @param cause
	 */
	public ControllingException(Throwable cause) {
		super(cause);
	}

	/**
	 * Constructor.
	 * @param message
	 * @param cause
	 */
	public ControllingException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Constructor.
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public ControllingException(String message, Throwable cause, boolean enableSuppression,	boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
