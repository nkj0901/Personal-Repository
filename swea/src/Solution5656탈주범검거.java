import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution5656탈주범검거 {
	static int N, M, L;
	static int[][] arr;
	static boolean[][] visited;
	static Queue<Node> queue;

	static class Node {
		int r, c, dir, cnt;

		Node(int r, int c, int dir, int cnt) {
			this.r = r;
			this.c = c;
			this.dir = dir;
			this.cnt = cnt;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {

			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // 세로r
			M = Integer.parseInt(st.nextToken()); // 가로c
			int R = Integer.parseInt(st.nextToken()); // 홀r
			int C = Integer.parseInt(st.nextToken()); // 홀c
			L = Integer.parseInt(st.nextToken()); // 시간

			arr = new int[N][M];
			visited = new boolean[N][M];
			queue = new LinkedList<>();

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			bfs(R, C);

			int ans = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (visited[i][j] == true) {
						ans += 1;
					}
				}
			}

//			for (boolean[] a : visited) {
//				System.out.println(Arrays.toString(a));
//			}

			System.out.println("#" + t + " " + ans);
		}
	}

	static int[] dr = { -1, 0, 1, 0 };// 상우하좌
	static int[] dc = { 0, 1, 0, -1 };

	private static void bfs(int r, int c) {
		Node node = new Node(r, c, arr[r][c], 0);
		queue.add(node);

		while (!queue.isEmpty()) {
			Node n = queue.poll();

			if (n.cnt >= L)
				continue;

			visited[n.r][n.c] = true;

			for (int i = 0; i < 4; i++) {
				int nr = n.r + dr[i];
				int nc = n.c + dc[i];

				if (!possible(n.r, n.c, nr, nc, i))
					continue;

				queue.add(new Node(nr, nc, arr[nr][nc], n.cnt + 1));

			}
		}
	}

	// 상 0 우 1 하 2 좌 3
	private static boolean possible(int r, int c, int nr, int nc, int i) {
		if (nr < 0 || nc < 0 || nr >= N || nc >= M)
			return false;
		if (visited[nr][nc] || arr[nr][nc] == 0)
			return false;

		int o = arr[r][c];
		int n = arr[nr][nc];
		// 위로 갈때
		if (i == 0) {
			if (o == 1 || o == 2 || o == 4 || o == 7) {
				if (n == 3 || n == 4 || n == 7)
					return false;
			} else if (o == 3 || o == 5 || o == 6)
				return false;
		} else if (i == 1) { // 오른쪽으로 갈 때
			if (o == 1 || o == 3 || o == 4 || o == 5) {
				if (n == 2 || n == 4 || n == 5)
					return false;
			} else if (o == 2 || o == 6 || o == 7) {
				return false;
			}
		} else if (i == 2) { // 아래로 갈 때
			if (o == 1 || o == 2 || o == 5 || o == 6) {
				if (n == 3 || n == 5 || n == 6)
					return false;
			} else if (o == 3 || o == 4 || o == 7) {
				return false;
			}
		} else if (i == 3) { // 왼쪽으로 갈 때
			if (o == 1 || o == 3 || o == 6 || o == 7) {
				if (n == 2 || n == 6 || n == 7)
					return false;
			} else if (o == 2 || o == 4 || o == 5) {
				return false;
			}
		}
		return true;
	}
}
