/**
 * 
 */
package com.shop.restmongorepository.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Arnaud
 *
 */

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Some constraints were violated ...")
public class ConstraintsViolationException extends Exception {

	static final long serialVersionUID = -3387516993224229948L;
	
	public ConstraintsViolationException(String message) {
		super(message);
	}
}
