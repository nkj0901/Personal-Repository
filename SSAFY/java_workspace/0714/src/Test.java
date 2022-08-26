import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
//		사용자의 입력을 받기 위한 초기작업
		Scanner sc = new Scanner(System.in);
//		주석은 프로그램 실행 시 무시됩니다.
//		System.out.println("Hello World");
//		System.out.println("Welcome to Hello");
		int num;
//		공간만 만들어 준 것.
		int a = sc.nextInt();
		int b = sc.nextInt();
//		num = a + b;
//		같은 타입의 데이터끼리의 연산은 해당 타입이 나온다.
//		/은 우리가 알고있던 나누기가 아니라,몫을 구하기 
//		%는 나머지를 구하기
//		이것은 정수 3, 이것은 실수 3 -> 3.0, 3f
		
		double f_num = 10 / 3.0;
		
		System.out.println(f_num);
	}
}

// 비교연산자는 두개의 숫자를 비교하고 결과는 진리값( true / false)
// + - * / % 는 결과도 숫자
// &&(and) ||(or)는 논리 연산자로써, 두개의 진리값을 연산하여 결과는 진리값( true, false)
//		3 < x < 7 ?
//		int x = 2;
//		System.out.println(x > 3 && x < 7);
//
//		어떤 수가 3의 배수인가
//		int x = 37;
//		System.out.println(x % 3 == 0);
		
		