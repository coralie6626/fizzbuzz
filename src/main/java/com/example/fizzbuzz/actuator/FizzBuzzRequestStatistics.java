package com.example.fizzbuzz.actuator;

import java.util.Comparator;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.LongAdder;

import org.springframework.stereotype.Component;

/**
 * In-memory statistics collected for successful FizzBuzz HTTP requests.
 */
@Component
public class FizzBuzzRequestStatistics {

	private final ConcurrentHashMap<RequestParameters, LongAdder> requestCounts = new ConcurrentHashMap<>();

	public void record(int int1, int int2, int limit, String str1, String str2) {
		RequestParameters parameters = new RequestParameters(int1, int2, limit, str1, str2);
		requestCounts.computeIfAbsent(parameters, ignored -> new LongAdder()).increment();
	}

	public Optional<MostFrequentFizzBuzzRequest> mostFrequentRequest() {
		return requestCounts.entrySet().stream()
				.map(entry -> new MostFrequentFizzBuzzRequest(
						entry.getKey().int1(), entry.getKey().int2(), entry.getKey().limit(),
						entry.getKey().str1(), entry.getKey().str2(), entry.getValue().sum()))
				.max(Comparator.comparingLong(MostFrequentFizzBuzzRequest::hits));
	}

	private record RequestParameters(int int1, int int2, int limit, String str1, String str2) {
	}
}
