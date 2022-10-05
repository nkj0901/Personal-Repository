import java.util.Arrays;
import java.util.Scanner;

public class 최소동전 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		int[] money = new int[N + 1];

		for(int i = 1; i <= N; i++) {
			int min = Integer.MAX_VALUE;
			//1원 적은 부분에 1원 다하기
			min = Math.min(min, money[i-1]+1);
			
			//4원 적은 부분에 4원 더하기
			if( i >= 4 )min = Math.min(min, money[i-4]+1);
			
			//6원 적은 부분에 6원 더하기
			if( i >= 6 )min = Math.min(min, money[i-6]+1);
			
			money[i] = min;
		}
		
		System.out.println(money[N]);
		System.out.println(solve(N));
		
		memo = new int[N+1];
		Arrays.fill(memo, -1);
		memo[0] = 0;
		System.out.println(solve2(N));
	}

	private static int solve(int n) {

		if (n < 0)
			return 987654321;

		// 기저 조건
		if (n == 0)
			return 0;

		return Math.min(Math.min(solve(n - 1) + 1, solve(n - 4) + 1), solve(n - 6) + 1);
	}

	// 하향식으로 짜보자
	static int[] memo;
	private static int solve2(int n) {

		if (n < 0)
			return 987654321;

		if (memo[n] != -1) {
			return memo[n];
		}
//
//		// 기저 조건
//		if (n == 0)
//			return 0;

		memo[n] = Math.min(Math.min(solve(n - 1), solve(n - 4)), solve(n - 6))+1;
		return memo[n];
	}

}
