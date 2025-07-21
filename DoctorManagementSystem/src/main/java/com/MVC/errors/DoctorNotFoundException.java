package com.MVC.errors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Custom exception thrown when a requested Doctor record is not found.
 * 
 * When this exception is thrown, it results in an HTTP 502 BAD_GATEWAY response.
 * (Note: You can change the status code to something more appropriate like 404 if preferred.)
 * 
 * Author: Your Name
 */
@SuppressWarnings("serial")
@ResponseStatus(value = HttpStatus.BAD_GATEWAY)
public class DoctorNotFoundException extends Exception {

    /**
     * Constructor that accepts a custom exception message.
     * 
     * @param msg The detail message explaining the exception.
     */
    public DoctorNotFoundException(String msg) {
        super(msg);
    }

    /**
     * Default constructor with no message.
     */
    public DoctorNotFoundException() {
        super();
    }
}
