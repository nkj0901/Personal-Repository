package com.ssafy.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.model.dto.Member;

@RestController
@RequestMapping("/rest4")
public class TestController4 {

//	@PathVariable
//	http://localhost:8080/rest4/board/1
//	http://localhost:8080/rest4/board/2
//	http://localhost:8080/rest4/board/999

//	@GetMapping("/board/{id}")
//	public String test1(@PathVariable() int id) {
//		return "PathVariable : " + id;
//	}
	@GetMapping("/board/{id}")
	public String test1(@PathVariable("id") int no) {
		return "PathVariable : " + no;
	}

//	application/x-www-form-urlencoded 
	@PostMapping("/test2")
	public String test2(Member m) {
		return m.toString();
	}
	
//	http://localhost:8080/mvc/rest4/test3 
//	JSON 형태의 값을 저기 바구니에 푝푝 넣고 싶을때!!!!!
//	{
//		  "name": "2zeewoo",
//		  "id" : "ssafy",
//		  "password" :"1234"
//		}
	@PostMapping("/test3")
	public String test3(@RequestBody Member m) {
		return m.toString();
	}
	
	
	// ResponseEntity : 응답하려는 데이터 + 응답코드 + 응답헤더 조작까지...
//	ResponseEntity<T> : T 는 Body에 들어갈 데이터 타입
	@GetMapping("/test4")
	public ResponseEntity<String> test4() {
		HttpHeaders headers = new HttpHeaders();
		headers.add("auth", "admin");
		
		return new ResponseEntity<String>("OK", headers, HttpStatus.CREATED);
	}

}
