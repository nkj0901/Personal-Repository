import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main4963섬의개수dfs {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		while (true) {
			st = new StringTokenizer(br.readLine());
			c = Integer.parseInt(st.nextToken());
			r = Integer.parseInt(st.nextToken());

			if (r == 0 && c == 0)
				break;

			arr = new int[r][c];

			// 배열채우기
			for (int i = 0; i < r; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < c; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int cnt = 0;
			for (int i = 0; i < r; i++) {
				for (int j = 0; j < c; j++) {
					if (arr[i][j] == 1) {
						cnt++;
						// 연결된 육지를 삭제
						dfs(i, j);
					}
				}
			}
			bw.write(cnt + "\n");
		}
		bw.flush();
		br.close();
		bw.close();
	}

	static int r, c;
	static int[][] arr;

	static void dfs(int x, int y) {
		// 사방탐색해면서 그게 일이면 0으로 바꿔주고
		arr[x][y] = 0;
		for (int i = 0; i < 8; i++) {
			int nr = x + dr[i];
			int nc = y + dc[i];
			// 범위 한정
			if (nr >= 0 && nr < r && nc >= 0 && nc < c) {
				if (arr[nr][nc] == 1) {
					dfs(nr, nc);
				}
			}
		}
	}

	static int[] dr = { 0, -1, -1, -1, 0, 1, 1, 1 };
	static int[] dc = { -1, -1, 0, 1, 1, 1, 0, -1 };

}
