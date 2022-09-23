import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main2468안전영역bfs {

	static class Node {
		int r;
		int c;

		Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];
		int[][] visited;
		int[] dr = { 0, -1, 0, 1 };
		int[] dc = { -1, 0, 1, 0 };

		// 배열채우며 최대값을 찾음
		int max = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				max = Math.max(max, map[i][j]);
			}
		}

		Queue<Node> queue = new LinkedList<>();
		int ans = 0;
		int cnt;
		// 깊이를 Max-1부터 내려가면서 숫자를 셈
		for (int d = max - 1; d >= 0; d--) {
			// 깊이마다 다른 visited 배열을 만들어준다.
			cnt = 0;
			visited = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					// 더 깊은 애가 있으면 그 애를 시작으로 사방 탐색을 시작
					if (map[i][j] > d && visited[i][j] == 0) {
						// 얘 좌표값으로 노드를 만들어서 queque에 넣어줌
						// 더 깊은 애가 있으면 갔다왔다고 visited에 표시를 해줌
						visited[i][j] = 1;
						cnt++;
						queue.add(new Node(i, j));

						// queue가 빌 때까지 while문을 돌면서 사방탐색을 해줌
						while (!queue.isEmpty()) {
							Node node = queue.poll();
							
							//사방탐색
							for (int z = 0; z < 4; z++) {
								int nr = node.r + dr[z];
								int nc = node.c + dc[z];

								if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
									if (map[nr][nc] > d && visited[nr][nc] == 0) {
										visited[nr][nc] = 1;
										
										queue.add(new Node(nr, nc));
									}
									// 주변에 더 큰애가 없으면 queue에 노드를 만들어 넣어주지 않기 때문에 while문이 종료가 됨
								}
							}
						}

					}
				}
			}
			ans = Math.max(ans, cnt);
		}
		bw.write(ans + "");
		bw.flush();
		br.close();
		bw.close();
	}
}
