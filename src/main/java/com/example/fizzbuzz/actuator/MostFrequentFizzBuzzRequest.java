package com.example.fizzbuzz.actuator;

/**
 * Parameters of the most frequently generated FizzBuzz request and its usage count.
 */
public record MostFrequentFizzBuzzRequest(
		int int1, int int2, int limit, String str1, String str2, long hits) {
}
