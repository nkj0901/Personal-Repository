package com.ssafy.spring;

public class Worker {
	//인터페이스를 넣으면 느슨한 결합
	// 실제 내가 사용할 랩탑이나 데스크으로 한정하면 강한 결합이 된다.
	private Computer computer;
	
	public Worker() {
		// 이렇게 하면 의존성이 Worker에게 있는 것
//		computer = new Desktop();
	}
	// 이렇게 하면 IoC(제어의 역전)
	// 누군가가 객체를 넣어주는 것을 의존성 주입이라고 한다.
	public void setComputer(Computer computer) {
		this.computer = computer;
	}
	
	public void doWork() {
		System.out.println(this.computer.getInfo() + " 로 일을 합니다.");
	}
}
