package com.example.fizzbuzz.actuator;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

/**
 * Actuator endpoint exposing the most frequently generated FizzBuzz request.
 */
@Component
@Endpoint(id = "statistics")
public class FizzBuzzStatisticsEndpoint {

	private final FizzBuzzRequestStatistics statistics;

	public FizzBuzzStatisticsEndpoint(FizzBuzzRequestStatistics statistics) {
		this.statistics = statistics;
	}

	@ReadOperation
	public ResponseEntity<MostFrequentFizzBuzzRequest> mostFrequentRequest() {
		return statistics.mostFrequentRequest()
				.map(ResponseEntity::ok)
				.orElseGet(() -> ResponseEntity.noContent().build());
	}
}
