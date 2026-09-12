package com.example.fizzbuzz.application;

import java.util.ArrayList;
import java.util.List;

import jakarta.validation.Valid;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * Default implementation of the configurable FizzBuzz generation use case.
 */
@Service
@Validated
public class DefaultFizzBuzzService implements FizzBuzzUseCase {

	@Override
	public List<String> generate(@Valid FizzBuzzRequest request) {
		List<String> result = new ArrayList<>(request.limit());
		for (int value = 1; value <= request.limit(); value++) {
			result.add(replacementFor(value, request));
		}
		return result;
	}

	private String replacementFor(int value, FizzBuzzRequest request) {
		boolean isMultipleOfFirst = value % request.int1() == 0;
		boolean isMultipleOfSecond = value % request.int2() == 0;

		if (isMultipleOfFirst && isMultipleOfSecond) {
			return request.str1() + request.str2();
		}
		if (isMultipleOfFirst) {
			return request.str1();
		}
		if (isMultipleOfSecond) {
			return request.str2();
		}
		return String.valueOf(value);
	}
}
