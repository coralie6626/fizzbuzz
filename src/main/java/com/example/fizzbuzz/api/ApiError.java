package com.example.fizzbuzz.api;

/**
 * API error representation to be used by the future exception handler.
 */
public interface ApiError {

	String code();

	String message();
}
