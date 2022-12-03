package 전략패턴;

public class DoWork	implements DoSomething {

	@Override
	public void doSomething() {
		System.out.println("일을 한다.");
		
	}

}
