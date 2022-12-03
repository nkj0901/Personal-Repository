package com.ssafy.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

// 메이븐 : 빌드관리도구, 라이브러리세팅에 엄청난 도움이 됨

// 프로젝트 우클릭, configure, convert to Maven Project
// 메이븐 문제 있을 시
// 1. alt + F5 update project.(플젝 우클릭 > 메이븐 > 업데이트 프로젝트)
// 2. 상단메뉴 project > clean
// 3. 이클립스 다 끄고, 사용자 > m2 > repository 꼬인 jar 삭제

// 메이븐을 통해서 우리 프로젝트  Spring 라이브러리 세팅(Spring Context)
// 스프링 설정파일 만들고 객체(bean) 등록하기
// 스프링 컨테이너 객체 빌드, 사용

public class Test {
	public static void main(String[] args) {
		
		ApplicationContext 
		context = new GenericXmlApplicationContext("applicationContext.xml");
		
		// 컨테이너로부터 내가 사용할 객체를 받아온다.
//		Worker worker = (Worker)context.getBean("workger");
		Worker worker = context.getBean("worker", Worker.class);
//		Computer computer = context.getBean("desktop", Computer.class);

//		worker.setComputer(computer);
		worker.doWork();
		
		// 스프링 컨테이너는, 빈 객체들을,, 언제 만들까?
		// 컨테이너가 만들어질 때
		// bean 객체에 lazy-init을 하면 getBean을 할 시에 객체 생성이 된다.
		
		Worker worker2 = context.getBean("worker", Worker.class);
		// 다른 애가 만들어질까? 놉. 싱글턴 같음
		// scope의 default 값은 싱글턴이라는 것을 알 수 있다. 
		// prototype으로 지정을 하면 달라그럴때마다 새거를 만든다.
	}
}
