import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main2206벽부수고이동하기 {


	static class Node {
		int r;
		int c;
		int cnt;
		int wall;

		Node(int r, int c, int cnt, int wall) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
			this.wall = wall;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int[][] maze = new int[R][C];
		boolean[][] visited = new boolean[R][C];
		boolean[][] bVisited = new boolean[R][C]; // 부신 벽 표시하는 것

		// 배열채우기
		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			for (int j = 0; j < C; j++) {
				maze[i][j] = str.charAt(j) - '0';
			}
		}

		Queue<Node> queue = new LinkedList<>();
		int[] dr = { -1, 0, 1, 0 };
		int[] dc = { 0, 1, 0, -1 };

		Node node = new Node(0, 0, 1, 0);
		queue.add(node);
		visited[0][0] = true;
		int ans = Integer.MAX_VALUE;

		while (!queue.isEmpty()) {
			Node n = queue.poll();

			if (n.r == R - 1 && n.c == C - 1) {
				ans = Math.min(ans, n.cnt);
				break;
			}

			// 사방탐색
			for (int i = 0; i < 4; i++) {
				int nr = n.r + dr[i];
				int nc = n.c + dc[i];

				if (nr < 0 || nr >= R || nc < 0 || nc >= C)
					continue;

				if (maze[nr][nc] == 0) {
					// 부순 적이 없으면 (능력 0)
					if (n.wall == 0) {
						if (visited[nr][nc] == false) {
							visited[nr][nc] = true; // 방문체크 후 큐에 넣어주기
							Node newNode = new Node(nr, nc, n.cnt + 1, n.wall);
							queue.add(newNode);
						}
					} else { // 벽을 부순 적이 있으면(능력x)
						if (visited[nr][nc] == false && bVisited[nr][nc] == false) {
							bVisited[nr][nc] = true;
							Node newNode = new Node(nr, nc, n.cnt + 1, 1);
							queue.add(newNode);

						}
					}
				}

				// 벽이 있고 부순 적이 없으면(능력 0) - 벽 부숴
				if (maze[nr][nc] == 1 && n.wall == 0) {
					bVisited[nr][nc] = true;
					Node newNode = new Node(nr, nc, n.cnt + 1, 1);
					queue.add(newNode);
				}
			}
		}

		ans = ans == Integer.MAX_VALUE ? -1 : ans;
		bw.write(ans + "");
		bw.flush();
		br.close();
		bw.close();
	}
}
