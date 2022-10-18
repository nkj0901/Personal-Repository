import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution5656벽돌깨기 {

	static class Node {
		int r, c;

		Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // 구슬 날리는 횟수
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());

			brick = new int[H][W];
			brickCopy = new int[H][W];
			sel = new int[N];
			visited = new boolean[W];
			queue = new LinkedList<>();

			// 배열받기
			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					brick[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			combi(W);
		}
	}

	static int N, W, H, cnt;
	static int[][] brick;
	static int[][] brickCopy;
	static int[] sel;
	static boolean[] visited;

	private static void combi(int n) {

		if (n == N) {
			
			for(int i = 0; i < H; i++) {
				for(int j = 0; j < W; j++) {
					brickCopy[i][j]=brick[i][j];
				}
			}
			
			boom();
			check();
			return;
		}

		for (int i = 0; i < W; i++) {

			if (visited[i])
				continue;

			visited[i] = true;
			sel[n] = i;
			combi(n + 1);
			visited[i] = false;
		}
	}

	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static Queue<Node> queue;

	// 선택된 3개의 줄을 터쳐보자
	private static void boom() {

		for (int i = 0; i < N; i++) {

			for (int h = 0; h < H; h++) {
				if (brickCopy[h][sel[i]] > 0) {
					queue.add(new Node(h, sel[i]));
					break;
				}
			}
			
			while(!queue.isEmpty()) {
				Node n = queue.poll();
				
				brickCopy[n.r][n.c]=0;
				
				//해당숫자만큼 옆에 지울거야
				for(int b = 1; b < brickCopy[n.r][n.c]; b++) {
					
					for(int d = 0; d < 4; d++) {
						int nr = n.r + (dr[d]+b);
						int nc = n.c + (dc[d]+b);
						
						if(nr < 0 || nc < 0 || nr >= H || nc >= W) continue;
						
						queue.add(brick)
						
						
					}
					
				}
				
				
			}
		}

	}

	private static int check() {
		// TODO Auto-generated method stub
		return null;
	}
}
