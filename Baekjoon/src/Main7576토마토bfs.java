import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main7576토마토bfs {
	static int r, c;

	static class Node {
		int r, c, day;

		Node(int r, int c, int day) {
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

		int[][] map = new int[r][c];

		for (int i = 0; i < r; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < c; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		Queue<Node> queue = new LinkedList<Node>();
		int[] dr = { 0, -1, 0, 1 };
		int[] dc = { -1, 0, 1, 0 };
		
		// 배열 순회하면서 1을 찾는다.
		// 일을 모두 큐에 넣는다.
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (map[i][j] == 1) {
					queue.add(new Node(i, j, 0));
				}
			}
		}		
		// 큐가 빌 때까지 사방탐색으로 주위를 1로 만든다.
		int ans = 0;
		while(!queue.isEmpty()) {
			
			Node node = queue.poll();
			
			for (int d = 0; d < 4; d++) {
				int nr = node.r+dr[d];
				int nc = node.c+dc[d];
				
				if (nr >= 0 && nr < r && nc >= 0 && nc < c) {
					if (map[nr][nc] == 0) {
						map[nr][nc] = 1;
						
						ans = Math.max(ans, node.day+1);
						queue.add(new Node(nr, nc, node.day+1));
					}
				}
			}
		}
		//배열 순회하면서 0이 있나 확인해보기
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (map[i][j]==0) ans = -1;
			}
		}
		
		bw.write(ans + " ");
		bw.flush();
		br.close();
		bw.close();
	}
}
