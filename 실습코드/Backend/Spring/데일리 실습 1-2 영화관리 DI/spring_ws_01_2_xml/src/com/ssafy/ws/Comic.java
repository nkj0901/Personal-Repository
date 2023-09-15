package com.ssafy.ws;

import org.springframework.stereotype.Component;

@Component
public class Comic implements Movie {

	@Override
	public String viewSomething() {
		return "나는 코믹 영화!";
	}

}
