package com.ssafy.mvc.model.service;

import org.springframework.stereotype.Service;

@Service
public class LoginServiceImp implements LoginService {

	@Override
	public boolean login(String id, String pw) {
		//DAO 갔다와야죠
		//아이디와 패스워드가 같으면 로그인 성공이야!!
		return id.equals(pw);
	}
}
