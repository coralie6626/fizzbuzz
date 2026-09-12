package com.example.fizzbuzz.actuator;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 * Records successful calls to the FizzBuzz HTTP endpoint.
 */
@Component
public class FizzBuzzRequestStatisticsInterceptor implements HandlerInterceptor {

	private final FizzBuzzRequestStatistics statistics;

	public FizzBuzzRequestStatisticsInterceptor(FizzBuzzRequestStatistics statistics) {
		this.statistics = statistics;
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception exception) {
		if (exception == null && response.getStatus() >= 200 && response.getStatus() < 300) {
			statistics.record(
					Integer.parseInt(request.getParameter("int1")),
					Integer.parseInt(request.getParameter("int2")),
					Integer.parseInt(request.getParameter("limit")),
					request.getParameter("str1"), 
					request.getParameter("str2"));
		}
	}
}
