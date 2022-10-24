import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main2583영역구하기 {

	static class Node {
		int r, c;

		Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken()); // 행
		c = Integer.parseInt(st.nextToken()); // 열
		int k = Integer.parseInt(st.nextToken()); // 직사각형 개수

		map = new int[r][c];

		for (int i = 0; i < k; i++) {

			st = new StringTokenizer(br.readLine());

			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken())-1;
			int y2 = Integer.parseInt(st.nextToken())-1;

			for (int x = x1; x <= x2; x++) {
				for (int y = y1; y <= y2; y++) {
					map[y][x] = 1;
				}
			}
		}

		queue = new LinkedList<>();
		List<Integer> list = new ArrayList<Integer>();

		int cnt = 0;
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (map[i][j] == 0) {
					cnt++;
					count = 1;
					bfs(i, j);
					list.add(count);
				}
			}
		}
		System.out.println(cnt);
		Collections.sort(list);
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + " ");
		}
		System.out.println();
	}

	static int r, c, count;
	static int[][] map;
	static Queue<Node> queue;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	private static void bfs(int i, int j) {
		queue.add(new Node(i, j));
		map[i][j] = 1;
		
		while (!queue.isEmpty()) {
			Node n = queue.poll();

			for (int d = 0; d < 4; d++) {
				int nr = n.r + dr[d];
				int nc = n.c + dc[d];

				if (nr < 0 || nc < 0 || nr >= r || nc >= c)
					continue;

				if (map[nr][nc] == 0) {
					count++;
					queue.add(new Node(nr, nc));
					map[nr][nc] = 1;
				}
			}
		}
	}
}
