package com.example.fizzbuzz;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import com.example.fizzbuzz.actuator.FizzBuzzRequestStatistics;
import com.example.fizzbuzz.actuator.FizzBuzzStatisticsEndpoint;
import com.example.fizzbuzz.actuator.MostFrequentFizzBuzzRequest;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

class FizzBuzzStatisticsTests {

	@Test
	void exposesTheMostFrequentRequestAndItsHitCount() {
		FizzBuzzRequestStatistics statistics = new FizzBuzzRequestStatistics();
		statistics.record(3, 5, 15, "fizz", "buzz");
		statistics.record(3, 5, 15, "fizz", "buzz");
		statistics.record(2, 7, 10, "foo", "bar");

		ResponseEntity<MostFrequentFizzBuzzRequest> response =
				new FizzBuzzStatisticsEndpoint(statistics).mostFrequentRequest();

		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals(new MostFrequentFizzBuzzRequest(3, 5, 15, "fizz", "buzz", 2), response.getBody());
	}

	@Test
	void returnsNoContentBeforeAnyRequestIsGenerated() {
		ResponseEntity<MostFrequentFizzBuzzRequest> response =
				new FizzBuzzStatisticsEndpoint(new FizzBuzzRequestStatistics()).mostFrequentRequest();

		assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
		assertNull(response.getBody());
	}
}
