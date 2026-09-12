package com.example.fizzbuzz.api;

import java.util.List;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * HTTP contract for generating a configurable FizzBuzz sequence.
 *
 * <p>An adapter implementing this contract will be added separately so that
 * transport concerns remain isolated from the application use case.</p>
 */
@RequestMapping(path = "/api/v1/fizzbuzz", produces = MediaType.APPLICATION_JSON_VALUE)
public interface FizzBuzzController {

	/**
	 * Generates values from 1 through {@code limit}, applying the supplied
	 * divisors and replacement strings.
	 *
	 * @param int1 first divisor
	 * @param int2 second divisor
	 * @param limit inclusive upper bound of the sequence
	 * @param str1 replacement for multiples of {@code int1}
	 * @param str2 replacement for multiples of {@code int2}
	 * @return the generated sequence
	 */
	@GetMapping
	List<String> generate(
			@RequestParam @Positive int int1,
			@RequestParam @Positive int int2,
			@RequestParam @Positive int limit,
			@RequestParam @NotNull String str1,
			@RequestParam @NotNull String str2);
}
