package com.ssafy.ws;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MovieAspect {

	//범위 함수를 만들어서 포인트 컷을 설정해준다.
	@Pointcut("execution(public void com.ssafy.ws.*.watchMovie())")
	public void mvpt() {
		
	}
	
//	@Before("mvpt()")
	public void before() {
		System.out.println("영화관을 갑니다.");
	}
//	@AfterReturning("mvpt()")
	public void afterReturning() {
		System.out.println("영화가 끝나고 나옵니다.");
	}
//	@AfterThrowing(value = "mvpt()", throwing = "th")
	public void afterThrowing(Throwable th) {
		if (th instanceof CallException) {
			((CallException) th).callException();
		}
	}
//	@After("mvpt()")
	public void after() {
		System.out.println("집에 갑니다.");
	}

	@Around("mvpt()")
	public void around(ProceedingJoinPoint pjt) {
		this.before();
		try {
			pjt.proceed();
			this.afterReturning();
		} catch (Throwable e) {
			this.afterThrowing(e);
		} finally {
			this.after();
		}
	}
}
