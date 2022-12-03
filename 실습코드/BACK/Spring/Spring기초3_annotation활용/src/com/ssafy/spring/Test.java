package com.ssafy.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Test {
	public static void main(String[] args) {
		ApplicationContext 
		context = new GenericXmlApplicationContext("applicationContext.xml");
		// 컨테이너로부터 내가 사용할 객체를 받아온다.
//		Computer computer = context.getBean("desktop", Computer.class);
//		System.out.println(computer.getInfo());
		Worker worker = context.getBean("worker", Worker.class);
		System.out.println(worker);
		worker.doWork();
	}
}
