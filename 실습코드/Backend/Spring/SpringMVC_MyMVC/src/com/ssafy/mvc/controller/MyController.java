package com.ssafy.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ssafy.mvc.model.dto.User;
import com.ssafy.mvc.model.service.MyService;

@Controller
public class MyController {

	private MyService myService;

//	@Autowired
//	public void setMyService(MyService myService) {
//		this.myService = myService;
//	}

	@RequestMapping("home")
	public ModelAndView handler1() {
		ModelAndView mav = new ModelAndView();

		System.out.println("home 이라는 요청이 왔다.");
//		myService.doSometing();
		// request.setAttribute 와 동일한 역할은 한다.
		mav.addObject("msg", "Hello World Welcome to SSAFY");

		// request.디스패처 한 것과 동일
		mav.setViewName("home");

		return mav;
	}

	// whattime 이라고 하는 요청이 들어왔을 때 현재 시간을 넣어 whattime.jsp (마숙)
	
	
	//get / post 각각에만 동작하는 RequestMappering
//	@GetMapping
//	@PostMapping
	
	//문자열 반환 (viewname)이 된다.!!!!
	@GetMapping("test1")
	public String test1() {
		return "test1";
	}
	
	
	//문자열 반환 
	@GetMapping("test2")
	public String test2(Model model) {
		model.addAttribute("msg", "만능 보따리 model 객체에 담아서 보내겠다");
		return "test2";
	}
	
	
	//Parmeter를 받고 싶다. 
	//변수명이 파라미터의 키값이 된다.
	//들어오지 않으면 null
	//기초자료형을 사용할 떄 Null 이라고 하는것은 말도 안되는것
	
	//기본값을 설정할수 있고 / 이건 꼭 필요없어 required 라고 하는 속성또한 있음
	@GetMapping("test3")
	public String test3(Model model, String id, String pw, @RequestParam(value = "age", defaultValue = "1")  int age) {
		model.addAttribute("myid", id);
		model.addAttribute("mypw", pw);
		
		System.out.println(age);
		return "test3";
	}
	
	
	//적절한 DTO를 준비를 해놓으니 알아서 쑉 넣어버리는 군 아이좋아.
	@PostMapping("test4")
	public String test4(Model model, User user) {
		System.out.println(user);
		
		return "test4";
	}
	
}
