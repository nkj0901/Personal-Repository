import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main16973직사각형탈출 {

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

		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());

		int[][] map = new int[R + 2][C + 2];
		boolean[][] check = new boolean[R + 2][C + 2];

		for (int i = 1; i <= R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 테두리 1로 체우기(세로)(가로)
		for (int i = 0; i < R + 2; i++) {
			map[i][0] = 1;
			map[i][C + 1] = 1;
		}

		for (int i = 0; i < C + 2; i++) {
			map[0][i] = 1;
			map[R + 1][i] = 1;
		}

		st = new StringTokenizer(br.readLine());

		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		int Sr = Integer.parseInt(st.nextToken());
		int Sc = Integer.parseInt(st.nextToken());
		int Fr = Integer.parseInt(st.nextToken());
		int Fc = Integer.parseInt(st.nextToken());

		Queue<Node> queue = new LinkedList<>();
		queue.add(new Node(Sr, Sc, 0));
		check[Sr][Sc] = true;
		int[] dr = { -1, 0, 1, 0 };
		int[] dc = { 0, 1, 0, -1 };
		int ans = -1;

		while (!queue.isEmpty()) {
			Node n = queue.poll();

			if (n.r == Fr && n.c == Fc) {
				ans = n.cnt;
				break;
			}
			
			if (check[n.r][n.c])
				continue;
			
			check[n.r][n.c] = true;

			loop: for (int d = 0; d < 4; d++) {
				int nr = n.r + dr[d];
				int nc = n.c + dc[d];
				
				if(nr < 0 || nr > R || nc < 0 || nc > C) continue;
				
				// 여기서 뽑은 인덱스 기준으로 사각형 범위만큼 보면서 1이 있나 확인

				if (d == 0) { // 윗줄만 보면 된다.
					for (int i = 0; i < W; i++) {
						if (nr-1 >= 0 && nc + i <= R) {
							if (map[nr-1][nc + i] == 1) {
								continue loop;
							}
						}
					}
				} else if (d == 1) {
					for (int i = 0; i < H; i++) {
						if (nr + i <= R && nc + 1 <= R) {
							if (map[nr + i][nc + 1] == 1) {
								continue loop;
							}
						}
					}
				} else if (d == 2) {
					for (int i = 0; i < W; i++) {
						if (nr + 1 <= R && nc + i <= R) {
							if (map[nr + 1][nc + i] == 1) {
								continue loop;
							}
						}
					}
				} else {
					for (int i = 0; i < W; i++) {
						if (nr + i <= R && nc - 1 >= 0) {
							if (map[nr + i][nc - 1] == 1) {
								continue loop;
							}
						}
					}
				}
				System.out.println(nr + " " +  nc);
				// 다 0이어서 for문을 통과하게 되면 큐에 넣어주기
				queue.add(new Node(nr, nc, n.cnt + 1));
			}
		}
		bw.write(ans + "");
		bw.flush();
		br.close();
		bw.close();
	}
}
