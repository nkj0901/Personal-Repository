package com.ssafy.cookie;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//서블릿으로 업그레이드 시키고
//쿠키를 한번 만들어 보자

//생성자 생성
//init
//

@WebServlet("/make")
public class MakeCookie extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String key = req.getParameter("key");
		String value = req.getParameter("value");
		
		System.out.println(key);
		System.out.println(value);
		
		//쿠키를 생성하자
		Cookie cookie = new Cookie(key, value);
		
		//유효시간(만료기간) - 초단위 
		cookie.setMaxAge(60); // -> 일분
		
		cookie.setMaxAge(0); //삭제와 동일한 효과
		
		resp.addCookie(cookie);
		
		HttpSession session = req.getSession();
		session.setAttribute("name", "hello");
		
		resp.sendRedirect("cookie1.jsp");
	}
}
