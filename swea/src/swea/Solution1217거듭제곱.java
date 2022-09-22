package swea;

import java.util.Scanner;

public class Solution1217거듭제곱 {
	static int N;
	static int result;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int T = 1; T <= 10; T++) {
			int t = sc.nextInt();
			
			N = sc.nextInt();
			int M = sc.nextInt();
			
			System.out.println("#" + t + " " + pow(N, M));
		}
	}
	
	public static int pow(int N, int M) {
		
		if (M == 1) return N;
		else {
			result = pow(N, M/2);
			if (M%2==0) {
				return result * result;
			} else {
				return result * result * N;
			}
		}
	}
}
