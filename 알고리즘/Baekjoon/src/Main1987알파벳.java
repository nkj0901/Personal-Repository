import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1987알파벳 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		arr = new char[R][C];
		check = new boolean[R][C];
		numCheck = new boolean[91];

		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			for (int j = 0; j < C; j++) {
				arr[i][j] = str.charAt(j);
			}
		}

		ans = 1;
		numCheck[arr[0][0]]=true;
		dfs(0,0,1);

		System.out.println(ans);

	}

	static char[][] arr;
	static boolean[][] check;
	static boolean[] numCheck;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static int ans, R, C;

	private static void dfs(int r, int c, int cnt) {
		
		for(int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			
			if (nr < 0 || nc < 0 || nr >= R || nc >= C ) continue;
			if (check[nr][nc]) continue;
			if (numCheck[arr[nr][nc]]) continue;
			
			check[nr][nc] = true;
			numCheck[arr[nr][nc]] = true;
			dfs(nr, nc, cnt+1);
			ans = Math.max(ans, cnt+1);
			check[nr][nc] = false;
			numCheck[arr[nr][nc]] = false;
		}
	}

	static class Node {
		int r, c, cnt;

		Node(int r, int c, int cnt) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}
	}
}
