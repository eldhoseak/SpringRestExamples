package com.spring.rest.exception;

public class ResourceNotFoundException extends Exception {

	private static final long serialVersionUID = -9079454849611061574L;

	public ResourceNotFoundException() {
		super();
	}

	public ResourceNotFoundException(final String message) {
		super(message);
	}

}