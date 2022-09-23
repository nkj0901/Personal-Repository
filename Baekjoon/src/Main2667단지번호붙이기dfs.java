import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main2667단지번호붙이기dfs {
	static int N;
	static int[][] arr;
	static int cnt;

	static int[] dr = { 0, -1, 0, 1 };
	static int[] dc = { -1, 0, 1, 0 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];

		// 배열채우기
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				arr[i][j] = str.charAt(j) - '0';
			}
		}

		List<Integer> list = new ArrayList<Integer>();
		// 순회하면서 1인 곳을 찾는다
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (arr[i][j] == 1) {

					// 확인한 부분은 0으로 바꾼다.
					arr[i][j] = 0;

					cnt = 1;
					dfs(i, j);
					list.add(cnt);
				}
			}
		}
		Collections.sort(list);
		bw.write(list.size() + "\n");
		for (int i = 0; i < list.size(); i++) {
			bw.write(list.get(i) + "\n");
		}
		bw.flush();
		br.close();
		bw.close();
	}

	static void dfs(int r, int c) {
		// 팔방참색을 하면서 주변에 1인 있는지 찾아본다.
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
				if (arr[nr][nc] == 1) {
					// 중복되면 안되니까 0으로 만들어주기
					arr[nr][nc] = 0;
					// 1이있으면 cnt++
					cnt = cnt + 1;
					dfs(nr, nc);
				}
			}
		}
	}
}