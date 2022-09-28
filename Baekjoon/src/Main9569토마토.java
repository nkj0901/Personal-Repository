import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main9569토마토 {
	static int r, c, h;

	static class Node {
		int h, r, c, day;

		Node(int h, int r, int c, int day) {
			this.h = h;
			this.r = r;
			this.c = c;
			this.day = day;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		c = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());

		int[][][] map = new int[h][r][c];

		for (int i = 0; i < h; i++) {
			for (int j = 0; j < r; j++) {
				st = new StringTokenizer(br.readLine());
				for (int z = 0; z < c; z++) {
					map[i][j][z] = Integer.parseInt(st.nextToken());
				}
			}
		}

		Queue<Node> queue = new LinkedList<Node>();
		int[] dh = { 0, 0, 0, 0, 1, -1 }; //상하좌우앞뒤
		int[] dr = { 0, -1, 0, 1, 0, 0 };
		int[] dc = { -1, 0, 1, 0, 0, 0 };

		// 배열 순회하면서 1을 찾는다.
		// 일을 모두 큐에 넣는다.
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < r; j++) {
				for (int z = 0; z < c; z++) {
					if (map[i][j][z] == 1) {
						queue.add(new Node(i, j, z, 0));
					}
				}
			}
		}
		// 큐가 빌 때까지 육방탐색으로 주위를 1로 만든다.
		int ans = 0;
		while (!queue.isEmpty()) {
			Node node = queue.poll();
			ans = node.day;

			for (int d = 0; d < 6; d++) {
				int nh = node.h + dh[d];
				int nr = node.r + dr[d];
				int nc = node.c + dc[d];

				if (nh >= 0 && nh < h && nr >= 0 && nr < r && nc >= 0 && nc < c) {
					if (map[nh][nr][nc] == 0) {
						map[nh][nr][nc] = 1;
						queue.add(new Node(nh, nr, nc, node.day + 1));
					}
				}
			}
		}
		// 배열 순회하면서 0이 있나 확인해보기
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < r; j++) {
				for(int z = 0; z < c; z++) {
					if (map[i][j][z] == 0)
						ans = -1;
				}
			}
		}

		bw.write(ans + " ");
		bw.flush();
		br.close();
		bw.close();
	}
}
