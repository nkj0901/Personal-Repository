import java.util.Scanner;

public class Main10872팩토리얼 {
	static int ans=1;
	
	public static void fac(int N) {
		if(N == 0) {
			return;
		}
		ans*= N;
		fac(N-1);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();		
		fac(N);
		
		System.out.println(ans);
	}
}
