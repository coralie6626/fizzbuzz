package com.example.fizzbuzz;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import com.example.fizzbuzz.application.DefaultFizzBuzzRequest;
import com.example.fizzbuzz.application.FizzBuzzUseCase;
import jakarta.validation.Validator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest
class FizzbuzzApplicationTests {

	@Autowired
	private ApplicationContext applicationContext;

	@Autowired
	private Validator validator;

	@Autowired
	private FizzBuzzUseCase fizzBuzzUseCase;

	@Test
	void contextLoads() {
		assertNotNull(applicationContext);
	}

	@Test
	void generatesNumbersAndReplacementsForBothDivisors() {
		List<String> result = fizzBuzzUseCase.generate(new DefaultFizzBuzzRequest(3, 5, 15, "fizz", "buzz"));

		assertEquals(List.of(
				"1", "2", "fizz", "4", "buzz", "fizz", "7", "8", "fizz", "buzz",
				"11", "fizz", "13", "14", "fizzbuzz"), result);
	}

	@Test
	void rejectsNonPositiveDivisors() {
		DefaultFizzBuzzRequest request = new DefaultFizzBuzzRequest(0, 5, 15, "fizz", "buzz");

		assertEquals(1, validator.validate(request).size());
	}

}
