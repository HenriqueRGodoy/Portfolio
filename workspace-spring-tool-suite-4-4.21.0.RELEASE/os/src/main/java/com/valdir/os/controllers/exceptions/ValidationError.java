package com.valdir.os.controllers.exceptions;

import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandardError{

	private static final long serialVersionUID = 1L;
	
	private List<FieldMissing> errors = new ArrayList<>();

	
	
	public ValidationError() {
		super();
	}

	public ValidationError(Long timeStamp, Integer status, String error) {
		super(timeStamp, status, error);
	}

	public ValidationError(Long timeStamp, Integer status, String error, List<FieldMissing> errors) {
		super(timeStamp, status, error);
		this.errors = errors;
	}

	public List<FieldMissing> getErrors() {
		return errors;
	}

	public void addErrors(String fieldName, String message) {
		this.errors.add(new FieldMissing(fieldName, message));
	}

}
