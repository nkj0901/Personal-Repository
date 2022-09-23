import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main2667단지번호붙이기bfs {
	static int N;
	static int[][] map;
	static int cnt;

	static int[] dr = { 0, -1, 0, 1 };
	static int[] dc = { -1, 0, 1, 0 };

	static class Node {
		int r, c;

		Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		map = new int[N][N];

		// 배열채우기
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}

		List<Integer> list = new ArrayList<Integer>();
		Queue<Node> queue = new LinkedList<Node>();

		// 배열돌면서 1를 찾아보고 1이 있으면 큐를 만들어서 큐에 집어넣기
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				cnt = 0;
				if (map[i][j] == 1) {
					map[i][j] = 0;
					// 4방탐색을 하면서 만약 1이 있으면 큐를 만들어서 넣기.
					queue.add(new Node(i, j));
					cnt++;
					
					while (!queue.isEmpty()) {
						Node node = queue.poll();
						for (int d = 0; d < 4; d++) {
							int nr = node.r + dr[d];
							int nc = node.c + dc[d];
							if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
								if (map[nr][nc] == 1) {
									map[nr][nc] = 0;
									cnt++;

									// 거기로 옮겨가서 또 사방탐색을 함
									queue.add(new Node(nr, nc));
								}
								// 주변에 1이 없으면 queue에 넣지 않기 때문에 while문이 끝남
							}
						}
					}
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
}
