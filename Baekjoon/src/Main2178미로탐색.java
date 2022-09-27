import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main2178미로탐색 {

	static class Node {
		int r;
		int c;
		int cnt;

		Node(int r, int c, int cnt) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int[][] maze = new int[R + 2][C + 2];
		boolean[][] visited = new boolean[R + 2][C + 2];
		int ans = Integer.MAX_VALUE;

		// 미로배열 채우기
		for (int i = 1; i <= R; i++) {
			String str = br.readLine();
			for (int j = 1; j <= C; j++) {
				maze[i][j] = str.charAt(j-1)-'0';
			}
		}
		
		Queue<Node> queue = new LinkedList<>();
		int[] dr = { -1, 0, 1, 0 };
		int[] dc = { 0, 1, 0, -1 };

		// 처음 시작은 1,1부터
		Node node = new Node(1, 1, 1);
		visited[1][1] = true;
		queue.add(node);

		loop : while (!queue.isEmpty()) {
			Node n = queue.poll();
			
			//사방탐색을 시작
			
			for(int i = 0; i < 4; i++) {
				int nr = n.r + dr[i];
				int nc = n.c + dc[i];
				if(maze[nr][nc] == 1 && visited[nr][nc] == false) {
					if(nr == R && nc == C) {
						ans = Math.min(ans, n.cnt+1);
					}
					
					visited[nr][nc] = true;
					Node newNode = new Node(nr, nc, n.cnt+1);
					queue.add(newNode);
				}
			}
		}
		System.out.println(ans);
	}
}
