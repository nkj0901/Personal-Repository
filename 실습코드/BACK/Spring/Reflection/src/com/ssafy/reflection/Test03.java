package com.ssafy.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class Test03 {
	public static void main(String[] args) {
		try {
			exam01();
			exam02();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 리플렉션을 이용한 객체 생성하기
	 * @throws Exception
	 */
	private static void exam01() throws Exception {
		System.out.println("exam01 --------------------------");
		// Dog d = new Dog();
		
		Class<Dog> clz = Dog.class;
		Constructor<Dog> constructor = clz.getDeclaredConstructor();
		Dog dog = constructor.newInstance();
		
//		Dog dog = Dog.class.getDeclaredConstructor().newInstance();
		
		dog.setName("메리~");
		System.out.println(dog.getName());
	}

	/**
	 * 리플렉션을 이용한 메서드 실행
	 * @throws Exception
	 */
	private static void exam02() throws Exception {
		System.out.println("exam02 --------------------------");
		/*
		     Dog d = new Dog();
		     d.setName("쫑");
		  	 String name = d.getName();
		  	 System.out.println(name);
		 */
		Class<?> clz = Class.forName("com.ssafy.reflection.Dog");
		
		Object obj = clz.getDeclaredConstructor().newInstance();
		
		// setName 메서드 객체 얻기
		Method method = clz.getDeclaredMethod("setName", String.class);
		
		// setName 메서드 실행 : invoke(객체, 매개변수 값...) 
		method.invoke(obj, "쫑");
		
		method = clz.getDeclaredMethod("getName");
		String name = (String)method.invoke(obj);
		System.out.println("name : " + name);
	}
}
