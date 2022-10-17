package com.ssafy.ws;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MovieTest {
	public static void main(String[] args) {
		
	 ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
	
	 Person audience = context.getBean("audience", Person.class);
	 
	 try {
		audience.watchMovie();
	} catch (CallException e) {
		// TODO Auto-generated catch block
	}
	 
	}
}
