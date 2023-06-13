package com.example.evaluacion.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException {
    /**
	 * 
	 */
	private static final long serialVersionUID = 2639089105225747245L;

	public UserNotFoundException() {
    }

    public UserNotFoundException(String message) {
        super("este es el error");
    }


}
