import java.util.Scanner;

public class Solution13772폭탄마 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {

			int N = sc.nextInt();
			int P = sc.nextInt();
			int[][] map = new int[N][N];

			// +모양
			int[] dr1 = { -1, 0, 1, 0 };
			int[] dc1 = { 0, 1, 0, -1 };
			// x모양
			int[] dr2 = { -1, -1, 1, 1 };
			int[] dc2 = { -1, 1, 1, -1 };

			// 배열 값 입력
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
				}
			}

			// 주어진 P만큼 반복문 돌면서 값 더하기
			int ans = 0;

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {

					int ans1 = map[i][j];
					int ans2 = map[i][j];
					int tmp = 0;

					for (int p = 1; p <= P; p++) {
						for (int d = 0; d < 4; d++) {
							if (i + (dr1[d] * p) >= 0 && j + (dc1[d] * p) >= 0 && i + (dr1[d] * p) < N
									&& j + (dc1[d] * p) < N) {
								ans1 += map[i + (dr1[d] * p)][j + (dc1[d] * p)];
							}
							if (i + (dr2[d] * p) >= 0 && j + (dc2[d] * p) >= 0 && i + (dr2[d] * p) < N
									&& j + (dc2[d] * p) < N) {
								ans2 += map[i + (dr2[d] * p)][j + (dc2[d] * p)];
							}

						}
					}
					tmp = Math.max(ans1, ans2);
					ans = Math.max(tmp, ans);
				}
			}
			System.out.println("#" + t + " " + ans);
		}
	}

}
