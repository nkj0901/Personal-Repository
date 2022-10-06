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

		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int[][] map = new int[R][C];
		int[][] dp = new int[R][C];

		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int[] dr = { -1, 0, 1, 0 };
		int[] dc = { 0, 1, 0, -1 };

		int nr, nc, cnt;
		boolean flag = false;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				cnt = 0;
				flag = false;
				for (int d = 0; d < 4; d++) {
					nr = i + dr[d];
					nc = j + dc[d];
					
					if (nr < 0 || nc < 0 || nr >= R || nc >= C)
						continue;
					if (map[nr][nc] < map[i][j]) cnt++;
					else if (map[nr][nc] > map[i][j]) flag = true;
				}
				
				if (flag == true && cnt > 0) {
					for (int d = 0; d < 4; d++) {
						nr = i + dr[d];
						nc = j + dc[d];
						if (nr < 0 || nc < 0 || nr >= R || nc >= C)
							continue;
						if (cnt == 1) {
							dp[nr][nc]= dp[i][j];
						} else {
							dp[nr][nc]+= dp[i][j]+(cnt-1);
						} 
					}
				}
			}
		}
		for(int[] a : dp) {
			System.out.println(Arrays.toString(a));
		}

	}
}
