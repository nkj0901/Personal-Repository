import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution1249보급로_다잌스트라 {

	static class Node implements Comparable<Node> {
		int r, c, time;

		Node(int r, int c, int time) {
			this.r = r;
			this.c = c;
			this.time = time;
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.time, o.time);
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {

			int N = Integer.parseInt(br.readLine());
			int[][] map = new int[N][N];
			boolean[][] visited = new boolean[N][N];
			int[][] dist = new int[N][N];
			int[] dr = { -1, 0, 1, 0 };
			int[] dc = { 0, 1, 0, -1 };

			for (int i = 0; i < N; i++) {
				String str = br.readLine();
				for (int j = 0; j < N; j++) {
					map[i][j] = str.charAt(j) - '0';
				}
			} // 입력

			// dist 배열 INF으로 채워주기
			for (int[] d : dist) {
				Arrays.fill(d, Integer.MAX_VALUE);
			}

			PriorityQueue<Node> queue = new PriorityQueue<>();
			//처음으로 0,0 넣어주기
			queue.add(new Node(0, 0, 0));
			dist[0][0] = 0;
			while (!queue.isEmpty()) {
				Node n = queue.poll();
				if (visited[n.r][n.c])
					continue;
				visited[n.r][n.c] = true;

				for (int i = 0; i < 4; i++) { //사방탐색
					int nr = n.r + dr[i];
					int nc = n.c + dc[i];

					if (nr < 0 || nc < 0 || nr >= N || nc >= N) //범위제한
						continue;
					
					if(visited[nr][nc]) continue;

					
					if (dist[nr][nc] > dist[n.r][n.c] + map[nr][nc]) {
						dist[nr][nc] = dist[n.r][n.c] + map[nr][nc];
						queue.add(new Node(nr, nc, dist[nr][nc])); //이렇게 넣으면 제일 작은 dist[?][?]값이 큐에서 튀어나옴
					}
				}
			}

			visited[0][0] = true;
			int ans = Integer.MAX_VALUE;
			System.out.println("#" + t + " " + dist[N - 1][N - 1]);
		}
	}
}
