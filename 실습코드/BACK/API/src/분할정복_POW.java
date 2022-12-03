import java.util.Scanner;

public class 분할정복_POW {
	static int result;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int C = sc.nextInt();
		int N = sc.nextInt();
		
		System.out.println(pow(C, N));
	}
	
	public static int pow(int C, int N) {
		//기저조건
		if(N==1) return C;
		
		if (N%2 == 0) {
			result = pow(C, N/2);
			return result*result;
		}
		else {
			result = pow(C, N/2);
			return result*result*C;
		}
	}
}
