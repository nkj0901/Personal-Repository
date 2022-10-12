package com.ssafy.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyAspect {
	
	//범위 함수를 만들어서 포인트 컷을 설정해준다.
	//함수이름이 포인트 컷에 대한 래퍼런스 참조값이 된다.
	@Pointcut("execution( public int com.ssafy.aop.*.doSomething())")
	public void mypt() {
		
	}
	
	//advice로 지정될 수 있는 부분은 4부분이 있다.
//	@Before("mypt()")
	public void before() {
		System.out.println("입실체크");
	}
	//정상적으로 끝났을 때
//	@AfterReturning(value="mypt()", returning = "num")
	public void afterReturning(int num) {
		System.out.println("퇴실체크 6시 정시" + num);
	}
	//예외가 발생했을 때
//	@AfterThrowing(value="mypt()", throwing = "th")
	public void afterThrowing(Throwable th) {
		System.out.println("임의 퇴실");
//		System.out.println(th);
		if( th instanceof CoronaException) {
			((CoronaException)th).handleException();
		}
	}
	//어쨋든 끝났을 때
//	@After("mypt()")
	public void after() {
		System.out.println("꿀같은 저녁시간");
	}
	
	@Around("mypt()")
	//포인트컷 전체를 감싼다 (한꺼번에 입맛대로 수동으로 하는 방법)
	public Object around(ProceedingJoinPoint pjt) {
		//1
		this.before();
		//2
		try {
			int num = (int) pjt.proceed();
			this.afterReturning(num);
			return num;
		} catch (Throwable e) {
			this.afterThrowing(e);
		} //핵심관심사항의 호출
		finally {
			this.after();
		}
		//3
		//4
		return null;
	}
}
