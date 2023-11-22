package com.ssafy.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.model.dto.Member;

@RestController
@RequestMapping("/rest2")
public class TestController2 {

//	http://localhost:8080/mvc/rest2/test1 
	@GetMapping("/test1")
	public String test1() {
		return "hi rest";
	}

//	http://localhost:8080/mvc/rest2/test2 : ResponseBody 붙이는순간 JSP 화면같은 것이 아니라 반환값 그자체를 데이터로 넘김.
	@GetMapping("/test2")
	public String test2() {
		return "hi rest";
	}

//	http://localhost:8080/mvc/rest2/test3
	@GetMapping("/test3")
	public Map<String, String> test3() {
		Map<String, String> data = new HashMap<String, String>();

		data.put("id", "ssafy");
		data.put("name", "이해건");
		data.put("password", "1234");

		return data; // JSON 반환해줘잉 같은건데...
	}

//	http://localhost:8080/mvc/rest2/test4
	@GetMapping("/test4")
	public Member test4() {
		Member m = new Member();
		m.setId("ssafy");
		m.setName("삭수민");
		m.setPassword("1234");

		return m;
	}

//	http://localhost:8080/mvc/rest2/test5
	@GetMapping("/test5")
	public List<Member> test5() {
		List<Member> list = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			Member m = new Member();
			m.setId("ssafy" + i);
			m.setName("삭수민" + i);
			m.setPassword("1234");
			list.add(m);
		}
		return list;
	}

}
