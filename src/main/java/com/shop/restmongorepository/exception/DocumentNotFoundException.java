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

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Could not find document with this id.")
public class DocumentNotFoundException extends Exception {

	static final long serialVersionUID = -3387516993334229948L;
	 
	 public DocumentNotFoundException(String message) {
		 super(message);
	 }
}
