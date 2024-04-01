package com.ssafy.ws;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
public class ApplicationConfig {
	
	@Bean
	public Audience audience() {
		return new Audience();
	}
	@Bean
	public MovieAspect movieAspect() {
		return new MovieAspect();
	}
	
}
