import java.util.Scanner;

public class 나이 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 나이 입력
		System.out.print("나이 : ");
		
		int a = sc.nextInt();
		int n = a / 10;
		
		System.out.println("현재 " + n + "n세이시군요!");
	}
}
