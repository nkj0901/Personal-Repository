package com.ssafy.reflection;

public class Test01 {
	public static void main(String[] args) {
		try {
			exam();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 클래스 정보 접근하는 3가지 방법
	 */
	private static void exam() throws Exception {
		// 1번 방식 : 클래스이름.class
		Class<?> clz = Dog.class;
		
		// 2번 방식 : Class.forName("패키지 포함 클래스명")
		Class<?> clz2 = Class.forName("com.ssafy.reflection.Dog");
		
		// 3번 방식 : 객체.getClass()
		Dog d = new Dog();
		Class<?> clz3 = d.getClass();
		
		System.out.println(clz == clz2);
		System.out.println(clz2 == clz3);
		
		String name = clz3.getName();
		String sName = clz3.getSimpleName();

		System.out.println(name);
		System.out.println(sName);
	}
}



















