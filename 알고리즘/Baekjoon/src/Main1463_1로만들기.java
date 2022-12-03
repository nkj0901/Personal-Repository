import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main1463_1로만들기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] dp = new int[N + 1];
		dp[0] = 0;
		dp[1] = 0;

		for (int i = 2; i <= N; i++) {
			// 숫자를 일로 뺐을 때
			dp[i] = dp[i - 1] + 1;
			// 숫자로 2로 나눴을 때
			if (i % 2 == 0) {
				dp[i] = Math.min(dp[i], dp[i / 2] + 1);
			}
			if (i % 3 == 0) {
				dp[i] = Math.min(dp[i], dp[i / 3] + 1);
			}
		}
		System.out.println(Arrays.toString(dp));
		System.out.println(dp[N]);
	}
}
