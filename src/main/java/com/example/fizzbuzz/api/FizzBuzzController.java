package com.example.fizzbuzz.api;

import java.util.List;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name = "FizzBuzz", description = "Generate configurable FizzBuzz sequences")
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
	@Operation(summary = "Generate a FizzBuzz sequence", responses = {
			@ApiResponse(responseCode = "200", description = "Sequence generated"),
			@ApiResponse(responseCode = "400", description = "Invalid request parameters")
	})
	List<String> generate(
			@RequestParam @Parameter(description = "First positive divisor", example = "3") @Positive int int1,
			@RequestParam @Parameter(description = "Second positive divisor", example = "5") @Positive int int2,
			@RequestParam @Parameter(description = "Inclusive upper bound", example = "15") @Positive int limit,
			@RequestParam @Parameter(description = "Replacement for multiples of int1", example = "fizz") @NotNull String str1,
			@RequestParam @Parameter(description = "Replacement for multiples of int2", example = "buzz") @NotNull String str2);
}
