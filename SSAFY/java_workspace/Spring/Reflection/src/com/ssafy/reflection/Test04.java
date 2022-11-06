/*
실행결과

----------------------------
등록된 URL : /board/detail
등록된 URL : /member/join
등록된 URL : /login/login
등록된 URL : /board/list
----------------------------
호출할 URI 입력 : /board/detail
detail 메서드 호출됨
호출할 URI 입력 : /login/login
login 메서드 실행됨
호출할 URI 입력 : /member/join
join 메서드 실행됨
호출할 URI 입력 : /member/service
등록된 URL이 아닙니다.
호출할 URI 입력 : quit
프로그램이 종료되었습니다.
 */
package com.ssafy.reflection;

import java.io.FileInputStream;
import java.lang.reflect.Method;
import java.util.Enumeration;
import java.util.Properties;
import java.util.Scanner;

public class Test04 {

	public static void main(String[] args) {
		try {
			Properties prop = new Properties();
			prop.load(
				new FileInputStream(
					"resources/test.properties"
				)
			);
			Enumeration<Object> keys = prop.keys();
			System.out.println("----------------------------"); 
			while (keys.hasMoreElements()) {
				System.out.println("등록된 URL : " + keys.nextElement());
			}
			System.out.println("----------------------------"); 
			
			Scanner sc = new Scanner(System.in);
			while (true) {
				System.out.print("호출할 URI 입력 : ");
				String url = sc.nextLine();
				
				if (url.equals("quit")) break;

				if (!prop.containsKey(url)) {
					System.out.println("등록된 URL이 아닙니다.");
					continue;
				}
				
				// ==== 위의 실행결과가 나오도록 코드 작성 = Start
				
				
				// ================================= End
				
			}
			System.out.println("프로그램이 종료되었습니다.");
			sc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}