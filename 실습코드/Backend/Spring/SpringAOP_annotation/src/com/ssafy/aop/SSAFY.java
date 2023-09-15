package com.ssafy.aop;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component("ssafy")
public class SSAFY implements Person {

	@Override
	public int doSomething() throws CoronaException {
		System.out.println("소와 같이 공부를 합니다.");
		if (new Random().nextBoolean())
			throw new CoronaException();
		return (int) (Math.random() * 45) + 1;
	}
}
