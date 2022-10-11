package com.ssafy.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Worker {
	
	private Computer computer;
	
	public Worker(Computer computer) {
		this.computer = computer;
	}
	
	//자동으로 타입이 일치하는 bean을 찾아다가 여기에 넣어준다.
	@Autowired
	public void setComputer(Computer computer) {
		this.computer = computer;
	}
	
	public void doWork() {
		System.out.println(this.computer.getInfo() + " 로 일을 합니다.");
	}
}
