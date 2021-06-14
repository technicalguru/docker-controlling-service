/**
 * 
 */
package rs.controlling.data.ledger;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Spring way of returning 404.
 * @author ralph
 *
 */
@ControllerAdvice
public class PostingNotFoundAdvice {

	@ResponseBody
	@ExceptionHandler(PostingNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	String aNotFoundHandler(PostingNotFoundException ex) {
		return ex.getMessage();
	}
}
