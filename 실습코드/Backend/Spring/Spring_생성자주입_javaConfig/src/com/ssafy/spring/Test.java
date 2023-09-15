package com.ssafy.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
public class Test {
	public static void main(String[] args) {
		ApplicationContext 
		context = new AnnotationConfigApplicationContext(ApplicationConfig.class);

		Desktop desktop = context.getBean("desktop", Desktop.class);
		System.out.println(desktop.getInfo());
	}
}
