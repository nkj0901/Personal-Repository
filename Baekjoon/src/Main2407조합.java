import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

public class Main2407조합 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();

		dp = new BigInteger[n+1];
		Arrays.fill(dp, BigInteger.valueOf(-1));
		dp[1] = BigInteger.valueOf(1);

		BigInteger ans = factorial(n).divide(factorial(m).multiply(factorial(n - m)));
		
		System.out.println(ans);
	}

	static BigInteger[] dp;

	private static BigInteger factorial(int n) {
		
		if (dp[n] == BigInteger.valueOf(-1)) {
			dp[n] = factorial(n - 1).multiply(BigInteger.valueOf(n));
			return dp[n];
		} else {
			return dp[n];
		}
	}
}
