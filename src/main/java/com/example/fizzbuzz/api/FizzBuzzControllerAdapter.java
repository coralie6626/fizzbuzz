package com.example.fizzbuzz.api;

import java.util.List;

import com.example.fizzbuzz.application.DefaultFizzBuzzRequest;
import com.example.fizzbuzz.application.FizzBuzzUseCase;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.validation.annotation.Validated;

/**
 * Spring MVC adapter for the FizzBuzz HTTP contract.
 */
@RestController
@Validated
public class FizzBuzzControllerAdapter implements FizzBuzzController {

	private final FizzBuzzUseCase fizzBuzzUseCase;

	public FizzBuzzControllerAdapter(FizzBuzzUseCase fizzBuzzUseCase) {
		this.fizzBuzzUseCase = fizzBuzzUseCase;
	}

	@Override
	public List<String> generate(int int1, int int2, int limit, String str1, String str2) {
		return fizzBuzzUseCase.generate(new DefaultFizzBuzzRequest(int1, int2, limit, str1, str2));
	}
}
