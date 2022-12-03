import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main1003피보나치함수 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {

			int N = Integer.parseInt(br.readLine());
			int[][] dp = new int[N + 1][2];

			for (int[] tmp : dp) {
				Arrays.fill(tmp, -1);
			}

			dp[0][0] = 1; // 0호출 수
			dp[0][1] = 0; // 0호출 수

			if (N >= 1) {
				dp[1][0] = 0; // 1호출 수
				dp[1][1] = 1; // 1호출 수
			}

			if (N >= 2) {
				for (int i = 2; i <= N; i++) {
					dp[i][0] = dp[i-1][0]+dp[i-2][0];
					dp[i][1] = dp[i-1][1]+dp[i-2][1];
				}
			}

			System.out.println(dp[N][0] + " " + dp[N][1]);
		}
	}
}
