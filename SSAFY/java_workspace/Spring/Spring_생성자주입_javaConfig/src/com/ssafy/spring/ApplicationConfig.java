package com.ssafy.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

	@Bean
	public Desktop desktop() {
		return new Desktop();
	}
	
	@Bean
	public Labtop labtop() {
		return new Labtop();
	}
	
	@Bean
	public Worker worker() {
		Worker worker = new Worker(desktop());
		return worker;
	}
}
