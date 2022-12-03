import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution5650핀볼게임 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {

			N = Integer.parseInt(br.readLine());

			pin = new int[N + 2][N + 2];

			for (int i = 0; i < N + 2; i++) {
				pin[0][i] = 5;
				pin[i][0] = 5;
				pin[N + 1][i] = 5;
				pin[i][N + 1] = 5;
			}

			// 배열채우기
			for (int i = 1; i <= N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 1; j <= N; j++) {
					pin[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			// 0인 곳 모두를 시작점으로 잡아보기
			int max = 0;
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if (pin[i][j] == 0) {

						for (int d = 0; d < 4; d++) {
							max = Math.max(max, score(i, j, 0, d));
						}
					}
				}
			}
			System.out.println("#" + t + " " + max);
		} // tc
	}

	static int N;
	static int[][] pin;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int[][] change = { { 0, 1, 2, 3 }, { 1, 3, 0, 2 }, { 3, 0, 1, 2 }, { 2, 0, 3, 1 }, { 1, 2, 3, 0 },
			{ 1, 0, 3, 2 } };

	private static int score(int r, int c, int cnt, int dir) {
		int R = r;
		int C = c;

		while (true) {

			int nr = R + dr[dir];
			int nc = C + dc[dir];

			// 블랙홀을 만나거나 제자리로 돌아왔다면?
			if (pin[nr][nc] == -1 || (nr == r && nc == c)) {
				return cnt;
			}

			// 다음칸이 0이면 이동해~
			if (pin[nr][nc] == 0) {
				R = nr;
				C = nc;
			}

			// 다음칸이 삼각형이야 그럼 삼각형에 따라서 방향 달라지니 확인하고 방향 바꿔줘
			else if (pin[nr][nc] > 0 && pin[nr][nc] < 6) { // 도형에 부딪힘
				// pin[nr][nc]는 무슨 도형인지 알려줌
				// change[pin[nr][nc]][dir]은 어느 방향으로 바꿔야 하는지 알려줌
				cnt++;
				R = nr;
				C = nc;
				dir = change[pin[nr][nc]][dir];
			}

			// 웜홀을 만났다면?
			else if (pin[nr][nc] > 5 && pin[nr][nc] < 11) {
				loop: for (int i = 1; i <= N; i++) {
					for (int j = 1; j <= N; j++) {
						if ((nr != i || nc != j) && pin[i][j] == pin[nr][nc]) {
							R = i;
							C = j;
							break loop;
						}
					}
				}
			}

		}
	}
}
