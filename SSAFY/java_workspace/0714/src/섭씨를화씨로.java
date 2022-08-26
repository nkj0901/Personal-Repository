import java.util.Scanner;

public class 섭씨를화씨로 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("섭씨온도 : ");
//		사용자로부터 섭씨온도를 입력받는다..
		double C = sc.nextDouble();
		double F = C * 9 / 5 + 32;
			System.out.println("화씨온도 : "+ F);
	}
}
