import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main16973직사각형탈출 {
	
	static int[][] map;
	static boolean[][] check;
	static int R, C, H, W, Sr, Sc, Fr, Fc, ans;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	
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
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new int[R][C];
		check = new boolean[R][C];

		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(br.readLine());

		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		Sr = Integer.parseInt(st.nextToken()) - 1;
		Sc = Integer.parseInt(st.nextToken()) - 1;
		Fr = Integer.parseInt(st.nextToken()) - 1;
		Fc = Integer.parseInt(st.nextToken()) - 1;

		
		ans = -1;
		bfs();

		bw.write(ans + "");
		bw.flush();
		br.close();
		bw.close();
	}
	
	static void bfs() {
		Queue<Node> queue = new LinkedList<>();
		queue.add(new Node(Sr, Sc, 0));
		check[Sr][Sc] = true;
		
		while (!queue.isEmpty()) {
			Node n = queue.poll();

			for (int d = 0; d < 4; d++) {
				int nr = n.r + dr[d];
				int nc = n.c + dc[d];

				if (nr == Fr && nc == Fc) {
					ans = n.cnt + 1;
					return;
				}

				if (nr < 0 || nr >= R || nc < 0 || nc >= C)
					continue;

				if (check[nr][nc] == false && map[nr][nc] == 0) {
					if(!check(nr, nc)) {
						continue;
					}
					
					queue.add(new Node(nr, nc, n.cnt + 1));
					check[nr][nc] = true;				}
			}
		}
	}
	
	static boolean check(int nr, int nc) {
		int x = nr+H;
		int y = nc+W;
		
		if(x-1 >= R || y-1 >= C) {
			return false;
		}
		
		for(int i = nr; i < x; i++) {
			for(int j = nc; j < y; j++) {
				if(map[i][j]==1) {
					return false;
				}
			}
		}
		return true;
	}
}
