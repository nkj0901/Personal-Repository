import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main1520내리막길 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[M][N];
		dp = new int[M][N];

		for (int[] a : dp) {
			Arrays.fill(a, -1);
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		ans = 0;
		System.out.println(dfs(0, 0));
		
		for(int[] d : dp) {
			System.out.println(Arrays.toString(d));
		}
	}

	static int M, N, ans;
	static int[][] map, dp;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	private static int dfs(int r, int c) {

		if (dp[r][c] != -1) {
			return dp[r][c];
		}

		// 기저파트
		if (r == M - 1 && c == N - 1) {
			return 1;
		}

		dp[r][c] = 0;
		// 사방탐색
		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];

			if (nr < 0 || nc < 0 || nr >= M || nc >= N)
				continue;

			if (map[nr][nc] < map[r][c]) {
				// 만약 작으면 갈 수 있는 길이니 재귀 호출
				dp[r][c]+=dfs(nr, nc);
			}

		}
		return dp[r][c];
	}
}
