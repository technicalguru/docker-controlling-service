/**
 * 
 */
package rs.controlling.rest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import rs.controlling.exception.AccountExistsException;
import rs.controlling.exception.IncompleteRequestException;
import rs.controlling.exception.InvalidAccountException;
import rs.controlling.exception.InvalidAmountException;
import rs.controlling.exception.PostingAlreadyExistsException;
import rs.controlling.exception.PostingNotFoundException;

/**
 * Spring way of returning 404.
 * @author ralph
 *
 */
@ControllerAdvice
public class PostingAdvice {

	@ResponseBody
	@ExceptionHandler(PostingNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	String notFoundHandler(PostingNotFoundException ex) {
		return ex.getMessage();
	}
	
	@ResponseBody
	@ExceptionHandler(PostingAlreadyExistsException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	String alreadExistsHandler(PostingAlreadyExistsException ex) {
		return ex.getMessage();
	}

	@ResponseBody
	@ExceptionHandler(InvalidAmountException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	String invalidAmountHandler(InvalidAmountException ex) {
		return ex.getMessage();
	}

	@ResponseBody
	@ExceptionHandler(AccountExistsException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	String existsHandler(AccountExistsException ex) {
		return ex.getMessage();
	}

	@ResponseBody
	@ExceptionHandler(InvalidAccountException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	String invalidAccountHandler(InvalidAccountException ex) {
		return ex.getMessage();
	}

	@ResponseBody
	@ExceptionHandler(IncompleteRequestException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	String incompleteRequestHandler(IncompleteRequestException ex) {
		return ex.getMessage();
	}

}
