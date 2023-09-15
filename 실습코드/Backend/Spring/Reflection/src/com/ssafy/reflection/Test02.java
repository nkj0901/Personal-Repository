package com.ssafy.reflection;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.lang.reflect.Type;

public class Test02 {
	public static void main(String[] args) {
		try {
			exam01();
//			exam02();
//			quiz();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Dog 클래스의 메서드 중에서 반환타입이 void 이고 set으로 시작하는 메서드의 이름을 화면에 출력
	 */
	private static void quiz() throws Exception {
		// 구현해보자
	}

	/**
	 * Class 객체의 메서드 정보 확인하기
	 */
	private static void exam01() throws Exception {
		Class<?> clz = Dog.class;
		
		System.out.println("Dog 의 모든 메서드 정보 출력");
		Method[] mArr = clz.getDeclaredMethods();
		for (Method method : mArr) {
			
			System.out.println("메서드 이름 : " + method.getName());
			
			Class<?> rClz = method.getReturnType();
			System.out.println("반환타입 : " + rClz.getName());
			
			// 파라미터 정보 확인
			Parameter[] pArr = method.getParameters();
			for (Parameter p : pArr) {
				Type t = p.getParameterizedType();
				System.out.println(t.getTypeName() + " " + p.getName());
			}
			System.out.println("----------------------------");
			
		}
	}
	
	private static void exam02() throws Exception {
		
		Class<?> clz = Dog.class;
		
		// setAge 메서드 접근
		Method method = clz.getDeclaredMethod(
				"setAge", int.class
		);
		
		System.out.println("메서드 이름 : " + method.getName());
		
		Class<?> rClz = method.getReturnType();
		System.out.println("반환타입 : " + rClz.getName());
		
		// 파라미터 정보 확인
		Parameter[] pArr = method.getParameters();
		for (Parameter p : pArr) {
			Type t = p.getParameterizedType();
			System.out.println(t.getTypeName() + " " + p.getName());
		}
		
		System.out.println("----------------------------");	
		
	}
}
























