import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main17069파이프옮기기2 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		long[][][] map = new long[4][N][N];
		// 출발은 가로 0,1임
		map[1][0][1] = 1;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[0][i][j] = Integer.parseInt(st.nextToken());

				// 1은 가로, 2는 세로, 3은 대각선

				// 1이면 이 자리에 올 경우의 수는 없음
				if (map[0][i][j] == 1)
					continue;

				// 이 자리에 가로로 있는 경우의 수는 가로,대각선배열 c-1봐야 함
				if (j - 1 >= 0) {
					map[1][i][j] += map[1][i][j - 1];
					map[1][i][j] += map[3][i][j - 1];
				}

				// 이 자리에 세로로 있는 경우의 수는 세로,대각선배열 r-1 봐야 함
				if (i - 1 >= 0) {
					map[2][i][j] += map[2][i - 1][j];
					map[2][i][j] += map[3][i - 1][j];
				}

				// 이 자리에 대각선으로 있는 경우의 수는 세로,대각선,가로배열 r-1,c-1 봐야함
				if (i - 1 >= 0 && j - 1 >= 0 && map[0][i - 1][j] == 0 && map[0][i][j - 1] == 0) {
					map[3][i][j] += map[1][i - 1][j - 1];
					map[3][i][j] += map[2][i - 1][j - 1];
					map[3][i][j] += map[3][i - 1][j - 1];
				}
			}
		}
		System.out.println(map[1][N - 1][N - 1] + map[2][N - 1][N - 1] + map[3][N - 1][N - 1]);
	}
}
