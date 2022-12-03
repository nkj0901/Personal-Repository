import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1912연속합 {
	 public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		int N = Integer.parseInt(br.readLine());
		int[] dp = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 첫번째 애는 비교할 대상이 없으니까 채워주고 시작
		dp[0] = Integer.parseInt(st.nextToken());
		int max = dp[0]; // 최대로 큰 값을 저장해줄거다
		for(int i = 1; i < N; i++) {
			int tmp = Integer.parseInt(st.nextToken());
			dp[i] = Math.max(dp[i-1]+tmp, tmp);
			max = Math.max(max, dp[i]);
		}
		System.out.println(max);
	 }
}
