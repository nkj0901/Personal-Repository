import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main17135캐슬디펜스 {
	static int cnt, C, R, D, ans;
	static int[][] map, mapcopy;
	static int[] select;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken()); // 행
		C = Integer.parseInt(st.nextToken()); // 열
		D = Integer.parseInt(st.nextToken());

		map = new int[R][C];
		mapcopy = new int[R][C];
		select = new int[3];

		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				mapcopy[i][j] = map[i][j];
			}
		}
		ans = 0;
		combination(0, 0);
		System.out.println(ans);
	}

	private static void combination(int idx, int sidx) {
		// 궁수자리 선택이 되었으면 공격을 시작해보자
		if (sidx == 3) {
			loop: while (true) {
				// 배열에 0밖에 없으면 그만해
				boolean flag = false;
				for (int i = 0; i < R; i++) {
					for (int j = 0; j < C; j++) {
						if (mapcopy[i][j] == 1)
							flag = true;
					}
				}
				if (flag == false) {
					break loop;
				}
				// 1번 공격해
				attack();
				// 한번 땡겨
				pull();
			}
			ans = Math.max(cnt, ans);
			cnt = 0;
			// 원래대로 고쳐주기
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					mapcopy[i][j] = map[i][j];
				}
			}
			return;
		}

		if (idx == C) {
			return;
		}

		// 선택한 것들 넣는 배열에 선택한 배열 번호를 넣어준다.
		select[sidx] = idx;
		// 이 자리 선택
		combination(idx + 1, sidx + 1);
		// 이 자리 선택 안함
		combination(idx + 1, sidx);

	}

	private static void pull() {
		for (int i = R - 2; i >= 0; i--) {
			for (int j = 0; j < C; j++) {
				mapcopy[i + 1][j] = mapcopy[i][j];
			}
		}
		for (int j = 0; j < C; j++) {
			mapcopy[0][j] = 0;
		}
	}

	private static int distance(int r1, int c1, int r2, int c2) {
		return Math.abs(r1 - r2) + Math.abs(c1 - c2);
	}

	private static void attack() {
		int r1, c1, min;
		boolean[][] visited = new boolean[R][C];

		// 궁수가 3명이니까 공격을 3번할거야
		for (int a = 0; a < 3; a++) {
			r1 = R;
			c1 = select[a];
			int r = Integer.MAX_VALUE;
			int c = Integer.MAX_VALUE;
			min = Integer.MAX_VALUE;
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					if (mapcopy[i][j] == 1) {
						if (distance(r1, c1, i, j) < min) {
							r = i;
							c = j;
							min = distance(r1, c1, i, j);
						} else if (distance(r1, c1, i, j) == min && c > j) {
							min = distance(r1, c1, i, j);
							r = i;
							c = j;
						}
					}
				}
			}
			if (distance(r1, c1, r, c) <= D) {
				visited[r][c] = true;
			}
		}
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				if (visited[i][j] == true) {
					mapcopy[i][j] = 0;
					cnt++;
				}
			}
		}
	}

}
