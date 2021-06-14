/**
 * 
 */
package rs.controlling.data.account;

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
public class AccountNotFoundAdvice {

	@ResponseBody
	@ExceptionHandler(AccountNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	String aNotFoundHandler(AccountNotFoundException ex) {
		return ex.getMessage();
	}
}
