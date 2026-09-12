package com.example.fizzbuzz.application;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

/**
 * Immutable implementation of the FizzBuzz generation parameters.
 */
public record DefaultFizzBuzzRequest(
		@Positive int int1,
		@Positive int int2,
		@Positive int limit,
		@NotNull String str1,
		@NotNull String str2)
		implements FizzBuzzRequest {
}
