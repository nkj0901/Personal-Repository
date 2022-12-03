package 템플릿메소드패턴;

public abstract class Person {
	private String name;	
	public abstract void doSomething();
	public void daily() {
		System.out.println("출근한다");
		doSomething();
		System.out.println("퇴근한다.");
	}

}
