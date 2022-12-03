import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main2589보물섬 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());	
		
		//배열생성
		map = new char[R][C];
		
		String str;
		for(int i = 0; i < R; i++) {
			str = br.readLine();
			for(int j = 0; j < C; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		
		max = Integer.MIN_VALUE;
		pq = new LinkedList<>();
		//배열 돌면서 L을 발견하면 그 지점으로부터 제일 먼 곳을 탐색해 본다.
		//제일 먼 곳이 있으면 max 값을 갱신할 것.
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				if(map[i][j] == 'L') {
					check = new boolean[R][C];
					bfs(i, j);
				}
			}
		}
		System.out.println(max);
	}
	static int max, R, C;
	static char[][] map;
	static boolean[][] check;
	static Queue<Node> pq;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	
	static class Node{
		int r, c, cnt;
		Node(int r, int c, int cnt){
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}
	}
	
	private static void bfs(int i, int j) {
		Node node = new Node(i, j, -1);
		pq.add(node);
		
		while(!pq.isEmpty()) {
			Node n = pq.poll();
			max = Math.max(max, n.cnt);
			
			if(check[n.r][n.c]) continue;
			check[n.r][n.c] = true;
			
			for(int d = 0; d < 4; d++) {
				int nr = n.r + dr[d];
				int nc = n.c + dc[d];
				
				if(nr < 0 || nc < 0 || nr >= R || nc >= C ) continue;
				
				if(map[nr][nc] == 'L') {
					pq.add(new Node(nr, nc, n.cnt+1));
				}
			}
		}
		
		
	}
}
