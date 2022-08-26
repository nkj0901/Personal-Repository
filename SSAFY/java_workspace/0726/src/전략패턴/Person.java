package 전략패턴;

public class Person {
	private DoSomething doSomething; //객체 선언. 인스턴스 변수
	private Eating eating; // 객체 선언. 인스턴스 변수
	
	public void daily() {
		doSomething.doSomething();
		eating.eating();
	}	
}
