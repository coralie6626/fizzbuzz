package com.example.fizzbuzz.api;

import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Translates validation errors into stable HTTP responses.
 */
@RestControllerAdvice
public class ApiExceptionHandler {

	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<ApiErrorResponse> handleInvalidRequest(ConstraintViolationException exception) {
		return ResponseEntity.badRequest()
				.body(new ApiErrorResponse(HttpStatus.BAD_REQUEST.name(), exception.getMessage()));
	}
}
