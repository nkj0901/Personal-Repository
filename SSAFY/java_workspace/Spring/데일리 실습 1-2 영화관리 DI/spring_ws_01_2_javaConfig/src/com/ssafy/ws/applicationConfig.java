package com.ssafy.ws;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.ssafy.ws"})
public class applicationConfig {
	
//	@Bean
//	public Comic comic() {
//		return new Comic();
//	}
//	
//	@Bean
//	public Action action() {
//		return new Action();
//	}
//	
//	@Bean
//	public Audience audience() {
//		Audience audience = new Audience(action());
//		return audience;
//	}
}
