package com.ssafy.ws;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Audience {
	Movie movie;
	
	@Autowired
	public Audience(@Qualifier("action")Movie movie) {
		this.movie = movie;
	}
	
//	@Autowired
//	@Qualifier("action")
//	public void setMovie(@Qualifier("comic")Movie movie) {
//		this.movie = movie;
//	}
	
	public void viewMovie() {
		System.out.println(this.movie.viewSomething()  + "를 봅니다~");
	}
}
