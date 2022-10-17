package com.ssafy.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ssafy.mvc.dto.User;
import com.ssafy.mvc.model.service.MyService;

@Controller
public class MyController {
	
	private MyService myService;
	
	@Autowired
	public void setMyService(MyService myService) {
		this.myService=myService;
	}

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
	
	//문자열 반환 (viewname)이 된다.
	@GetMapping("test1")
	public String test1() {
		return "test1";
	}
	
	@GetMapping("test2")
	public String test2(Model model) {
		model.addAttribute("msg", "만능보따리 model 객체에 담아서 보내겠다.");
		return "test2";
	}
	
	//파라미터를 받고 싶다.
	//변수명이 파라미터의 키값이 된다.
	//들어오지 않으면 null(참조자료형에서만)
	//기본자료형에서 입력이 들어오지 않으면 오류가 뜬다
	
	//기본값을 설정할 수 있고 이건 꼭 필요없다고 설정할 수 있다.(required라고 하는 속성이 있음)
	@GetMapping("test3")
	public String test3(Model model, String id, String pw, @RequestParam(value = "age", defaultValue = "1")int age) {
		model.addAttribute("myid", id);
		model.addAttribute("mypw", pw);
		System.out.println(age);
		return "test3";
	}
	
	@PostMapping("test4")
	public String test4(Model model, User user) {
		System.out.println(user);
		
		return "test4";
	}
}
