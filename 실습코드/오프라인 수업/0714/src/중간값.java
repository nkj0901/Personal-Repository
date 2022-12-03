import java.util.Scanner;

public class 중간값 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int b = n % 10;
		int c = (n / 10) % 10;
		int d = (n / 100) % 10;
		int e = (n / 1000) % 10;
		int a = b + c + d + e ;
		
		System.out.println(a);
		
		
}
}