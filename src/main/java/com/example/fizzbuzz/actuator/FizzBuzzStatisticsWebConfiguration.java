package com.example.fizzbuzz.actuator;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Registers monitoring that is specific to the FizzBuzz HTTP endpoint.
 */
@Configuration
public class FizzBuzzStatisticsWebConfiguration implements WebMvcConfigurer {

	private final FizzBuzzRequestStatisticsInterceptor interceptor;

	public FizzBuzzStatisticsWebConfiguration(FizzBuzzRequestStatisticsInterceptor interceptor) {
		this.interceptor = interceptor;
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(interceptor).addPathPatterns("/api/v1/fizzbuzz");
	}
}
