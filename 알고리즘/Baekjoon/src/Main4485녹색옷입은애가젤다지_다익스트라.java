import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main4485녹색옷입은애가젤다지_다익스트라 {

	static class Node implements Comparable<Node> {
		int r, c, rupee;

		Node(int r, int c, int rupee) {
			this.r = r;
			this.c = c;
			this.rupee = rupee;
		}

		@Override
		public int compareTo(Node o) {
			return this.rupee - o.rupee;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int cnt = 1; 
		while (true) {
			int N = Integer.parseInt(br.readLine());

			if (N == 0) break;

			int[][] arr = new int[N][N];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			PriorityQueue<Node> pq = new PriorityQueue<>();
			boolean[][] check = new boolean[N][N];
			pq.add(new Node(0,0,arr[0][0]));
			
			int[] dr = {-1, 0, 1, 0};
			int[] dc = {0, 1, 0, -1};
			int ans = 0;
			
			while(!pq.isEmpty()) {
				Node n = pq.poll();
				
				if(n.r == N-1 && n.c == N-1) {
					ans = n.rupee;
					break;
				}
				
				if(check[n.r][n.c]) continue;
				check[n.r][n.c] = true;
				
				for(int i = 0; i < 4; i++) {
					int nr = n.r+dr[i];
					int nc = n.c+dc[i];
					
					if(nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
					pq.add(new Node(nr, nc, n.rupee+arr[nr][nc]));
				}
			}
			System.out.println("Problem " + cnt++ + ": " +  ans);
		}
	}
}
