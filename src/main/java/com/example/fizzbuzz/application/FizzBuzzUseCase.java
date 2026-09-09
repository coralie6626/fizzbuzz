package com.example.fizzbuzz.application;

import java.util.List;

/**
 * Application boundary for generating a configurable FizzBuzz sequence.
 */
public interface FizzBuzzUseCase {

	/**
	 * Produces the values described by the supplied request.
	 *
	 * @param request generation parameters
	 * @return generated sequence
	 */
	List<String> generate(FizzBuzzRequest request);
}
