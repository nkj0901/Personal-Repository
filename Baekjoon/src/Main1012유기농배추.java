import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1012유기농배추 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {

			st = new StringTokenizer(br.readLine());

			c = Integer.parseInt(st.nextToken()); // 가로길이
			r = Integer.parseInt(st.nextToken()); // 세로길이
			int n = Integer.parseInt(st.nextToken()); // 배추 수

			map = new int[r][c];
			visited = new boolean[r][c];

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());

				map[y][x] = 1;
			}

			int ans = 0;
			for (int i = 0; i < r; i++) {
				for (int j = 0; j < c; j++) {
					if (map[i][j] == 1 && !visited[i][j]) {
						ans++;
						visited[i][j] = true;
						dfs(i, j);
					}
				}
			}
			System.out.println(ans);
		}
	}

	static int[][] map;
	static boolean[][] visited;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	static int r, c;

	private static void dfs(int i, int j) {
		
		for(int d = 0; d < 4; d++) {
			int nr = i+dr[d];
			int nc = j+dc[d];
			if(nr >= r || nc >= c || nr < 0 || nc < 0 ) continue;
			
			if(!visited[nr][nc] && map[nr][nc] == 1) {
				visited[nr][nc] = true;
				dfs(nr, nc);
			}
		}
	}
}
