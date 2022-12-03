package com.ssafy.spring;

import org.springframework.stereotype.Component;

//낙인을 찍을 때 그냥 찍으면 클래스명 첫글자 소문자로 만든 게 bean의 이름.
//이름을 정해주면 정해준 이름으로 빈이 등록된다.
@Component("computer")
public class Labtop implements Computer {

	@Override
	public String getInfo() {
		return "노트북!";
	}
}
