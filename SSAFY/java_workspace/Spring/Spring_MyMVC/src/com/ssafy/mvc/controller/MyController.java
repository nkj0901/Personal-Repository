package com.ssafy.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController {

	@RequestMapping("home")
	public ModelAndView Handler1() {
		ModelAndView mav = new ModelAndView();
		System.out.println("home이라는 요청이 왔다.");
		//request.setAttribute와 동일한 역할을 한다.
		mav.addObject("msg", "Hello World Welcome to SSAFY");
		//request.디스패치 한 것과 동일
		//home만 
		mav.setViewName("home");
		return mav;
	}
}
