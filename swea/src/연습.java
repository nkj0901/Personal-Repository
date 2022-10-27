import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 연습 {
	
	static class Node implements Comparable<Node>{
		int r, c, w;
		
		Node(int r, int c, int w){
			this.r = r;
			this.c = c;
			this.w = w;
		}

		@Override
		public int compareTo(Node o) {
			return this.w-o.w;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {

			int N = Integer.parseInt(br.readLine());

			int[][] map = new int[N][N];
			int[][] dist = new int[N][N];
			boolean[][] visited = new boolean[N][N];

			for (int i = 0; i < N; i++) {
				String str = br.readLine();
				for (int j = 0; j < N; j++) {
					map[i][j] = str.charAt(j)-'0';
				}
			}
			
			for (int[] d : dist) {
				Arrays.fill(d, Integer.MAX_VALUE);
			}
			
			PriorityQueue<Node> pq = new PriorityQueue<>();
			int[] dr = {-1, 0, 1, 0};
			int[] dc = {0, 1, 0, -1};
			pq.add(new Node(0,0,0));
			
			while(!pq.isEmpty()) {
				Node n = pq.poll();
				
				if(visited[n.r][n.c])continue;
				visited[n.r][n.c] = true;
				
				for(int d = 0; d < 4; d++) {
					int nr = n.r + dr[d];
					int nc = n.c + dc[d];
					
					if(nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
					
					if(dist[nr][nc] > n.w+map[nr][nc]) {
						dist[nr][nc] = n.w+map[nr][nc];
						
						pq.add(new Node(nr, nc, dist[nr][nc]));
					}
				}
			}
			
			
			int ans = dist[N-1][N-1];
			bw.write("#" + t + " " + ans + "\n");
		}
		bw.flush();
		br.close();
		bw.close();
	}
}
