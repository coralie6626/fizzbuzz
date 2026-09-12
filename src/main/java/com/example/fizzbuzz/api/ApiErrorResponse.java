package com.example.fizzbuzz.api;

/**
 * JSON response returned for invalid API requests.
 */
public record ApiErrorResponse(String code, String message) implements ApiError {
}
