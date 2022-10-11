package com.ssafy.spring;

public class Desktop implements Computer{

	@Override
	public String getInfo() {
		return "데스크탑!";
	}
}
