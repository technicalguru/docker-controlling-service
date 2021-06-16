/**
 * 
 */
package rs.controlling.rest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import rs.controlling.exception.AccountNotFoundException;

/**
 * Spring way of returning 404.
 * @author ralph
 *
 */
@ControllerAdvice
public class AccountAdvice {

	@ResponseBody
	@ExceptionHandler(AccountNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	String aNotFoundHandler(AccountNotFoundException ex) {
		return ex.getMessage();
	}
}
