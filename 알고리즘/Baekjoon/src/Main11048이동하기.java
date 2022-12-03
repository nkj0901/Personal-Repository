import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main11048이동하기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int[][] dp = new int[R][C];
		
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				int a = 0;
				int b = 0;
				int c = 0;
				
				if(i-1 >= 0 && j-1 >= 0) a = dp[i-1][j-1];
				if(i-1 >= 0) b = dp[i-1][j];
				if(j-1 >= 0) c = dp[i][j-1];
				
				dp[i][j] = Math.max(Math.max(a, b), c)+Integer.parseInt(st.nextToken());
			}
		}
		
		System.out.println(dp[R-1][C-1]);

	}
}
