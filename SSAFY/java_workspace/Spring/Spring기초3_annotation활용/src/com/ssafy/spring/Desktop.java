package com.ssafy.spring;

import org.springframework.stereotype.Component;

@Component
public class Desktop implements Computer{

	@Override
	public String getInfo() {
		return "데스크탑!";
	}

}
