import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main4963섬의개수bfs {
	static int r, c;
	static int[][] arr;
	static int[] dr = { 0, -1, -1, -1, 0, 1, 1, 1 };
	static int[] dc = { -1, -1, 0, 1, 1, 1, 0, -1 };

	static class Node {
		int r, c;

		Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

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

			// 탐색하면서 육지의 경우. 카운트를 세고 연결된 모든 육지를 제거
			int cnt = 0;
			for (int i = 0; i < r; i++) {
				for (int j = 0; j < c; j++) {
					if (arr[i][j] == 1) {
						cnt++;
						arr[i][j] = 0;

						// 해당 자리를 0으로 바꾼다.
						// 큐를 만든다.
						Queue<Node> queue = new LinkedList<>();
						// 노트를 만들고 노드를 큐에 집어넣는다.
						queue.add(new Node(i, j));

						// 그리고 큐에 노드가 없을 때까지 노드를 꺼내면서 8방 탐색을 한다.
						while (!queue.isEmpty()) {

							Node node = queue.poll();
							for (int d = 0; d < 8; d++) {
								int nr = node.r + dr[d];
								int nc = node.c + dc[d];

								if (nr >= 0 && nr < r && nc >= 0 && nc < c) {
									if (arr[nr][nc] == 1) {
										arr[nr][nc] = 0;
										queue.add(new Node(nr, nc));
									}
								}
								// 주의가 모든 0인 상태가 되면 return이 되면서 while문이 끄탄게 된다.
								// 그래서 다음 자리 확인하며 cnt++ 해간다.
							}
						}
					}
				}
			}
			bw.write(cnt+"\n");
		}
		bw.flush();
		br.close();
		bw.close();
	}
}
