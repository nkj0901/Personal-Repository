import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main1600말이되고픈원숭이 {

	static class Node {
		int r;
		int c;
		int cnt;
		int k;

		Node(int r, int c, int cnt, int k) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
			this.k = k;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int K = Integer.parseInt(br.readLine());

		st = new StringTokenizer(br.readLine());

		int W = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());

		int[][] map = new int[H][W];
		boolean[][][] check = new boolean[K+1][H][W];
		

		for (int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < W; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		Queue<Node> queue = new LinkedList<>();
		int[] monkeyR = { -1, 0, 1, 0 };
		int[] monkeyC = { 0, 1, 0, -1 };
		int[] horseR = { -2, -2, -1, 1, 2, 2, 1, -1 };
		int[] horseC = { -1, 1, 2, 2, 1, -1, -2, -2 };
		int ans = -1;
		
		queue.add(new Node(0, 0, 0, K));
		
		while(!queue.isEmpty()) {
			
			Node n = queue.poll();
			
			if (n.r == H-1 && n.c == W-1) {
				ans = n.cnt;
				break;
			}
			
			//말처럼 뛸 수 있다면
			if (n.k > 0) {
				
				//K를 썼을 경우
				for(int i = 0; i < 8; i++) {
					int nr = n.r + horseR[i];
					int nc = n.c + horseC[i];
					
					if(nr < 0 || nr >= H || nc < 0 || nc >= W)
						continue;
					
					if(map[nr][nc] == 1) continue;
					
					if (map[nr][nc] == 0 && check[n.k-1][nr][nc] == false) {
						check[n.k-1][nr][nc] = true; //방문 표시
						queue.add(new Node(nr, nc, n.cnt+1, n.k-1));
					}
				}
				
				//안 썼을 경우
				for(int i = 0; i < 4; i++) {
					int nr = n.r + monkeyR[i];
					int nc = n.c + monkeyC[i];
					
					if(nr < 0 || nr >= H || nc < 0 || nc >= W)
						continue;
					
					if(map[nr][nc] == 1) continue;
					
					if (map[nr][nc] == 0 && check[n.k][nr][nc] == false) {
						check[n.k][nr][nc] = true;
						queue.add(new Node(nr, nc, n.cnt+1, n.k));
					}
				}
			}
			
			else {
				//말처럼 뛸 수 없으니 그냥 가는 수 밖에
				for(int i = 0; i < 4; i++) {
					int nr = n.r + monkeyR[i];
					int nc = n.c + monkeyC[i];
					
					if(nr < 0 || nr >= H || nc < 0 || nc >= W)
						continue;
					
					if(map[nr][nc] == 1) continue;
					
					if (map[nr][nc] == 0 && check[n.k][nr][nc] == false) {
						check[n.k][nr][nc] = true;
						queue.add(new Node(nr, nc, n.cnt+1, n.k));
					}
				}
			}
		}
		bw.write(ans + "");
		bw.flush();
		br.close();
		bw.close();
	}
}
