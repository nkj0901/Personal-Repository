import java.util.Scanner;

public class 더하기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int a,b;
		while(true) {
		a = sc.nextInt();
		b = sc.nextInt();	
		
		if (a==0 && b==0)
			break;
		int n = a + b - 5;
		
		System.out.println(n);
		
		}
	}
}