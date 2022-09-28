import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution1949등산로 {

	static class Node {
		int r, c, height, cnt, cut;
		boolean[][] visited;

		Node(int r, int c, int height, int cnt, int cut, boolean[][] visited) {
			this.r = r;
			this.c = c;
			this.height = height;
			this.cnt = cnt;
			this.cut = cut;
			this.visited=visited;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			int[][] map = new int[N][N];


			// 값을 입력받으면서 제일 높은 곳을 찾기
			int max = 0;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());

					max = Math.max(max, map[i][j]);
				}
			}

			Queue<Node> queue = new LinkedList<>();
			int[] dr = { -1, 0, 1, 0 };
			int[] dc = { 0, 1, 0, -1 };
			boolean[][] visited;

			// 최대값인 곳을 찾아서 모두 queque에 넣는다.
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == max) {
						queue.add(new Node(i, j, max, 1, 0, visited = new boolean[N][N]));
					}
				}
			}
			int ans = 0;
			while (!queue.isEmpty()) {
				Node n = queue.poll();
				ans = Math.max(n.cnt, ans);
				n.visited[n.r][n.c] = true;

				for (int i = 0; i < 4; i++) {
					int nr = n.r + dr[i];
					int nc = n.c + dc[i];

					if (nr < 0 || nr >= N || nc < 0 || nc >= N) {
						continue;
					}
					
					if(n.visited[nr][nc]) continue;
					

					// 높이가 낮으면 그냥 이동
					if (map[nr][nc] < n.height) {
						queue.add(new Node(nr, nc, map[nr][nc], n.cnt + 1, 0, n.visited));
					}

					// 높이가 높고 내가 산을 깎은 적이 없을 때
					if (n.cut == 0 && map[nr][nc] >= n.height) {
						if (Math.abs(n.height - map[nr][nc]) < K) {
							int newHeight = map[nr][nc]-Math.abs(n.height - map[nr][nc]) - 1;
							queue.add(new Node(nr, nc, newHeight, n.cnt + 1, 1, n.visited));
						}
					}
				}
			}
			System.out.println("#" + t + " " + ans);
		}
	}
}
