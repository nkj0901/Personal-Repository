import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution6808규영이와인영이의카드게임 {

	static int[] A, B, sel;
	static int win, lose;
	static boolean[] visited;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {

			st = new StringTokenizer(br.readLine());
			A = new int[9]; // 규영
			B = new int[9]; // 인영 - 이거의 순열을 봐야 함
			sel = new int[9]; // 선택된 애들을 담을 곳
			boolean[] check = new boolean[18 + 1];
			visited = new boolean[9];

			for (int i = 0; i < 9; i++) {
				A[i] = Integer.parseInt(st.nextToken());
				check[A[i]] = true;
			}

			int idx = 0;
			for (int i = 1; i <= 18; i++) {
				if (check[i] == false) {
					B[idx++] = i;
				}
			}

			win = 0; lose = 0;
			dfs(0);

			System.out.println("#" + t + " " + win + " " + lose);
		}
	}

	private static void dfs(int idx) {

		if (idx == 9) {
			// sel에 담긴 순서대로 9번 게임을 해보자
			int gyu = 0;
			int in = 0;
			for (int i = 0; i < 9; i++) {
				if (A[i] > sel[i]) gyu += A[i] + sel[i];
				else if (A[i] < sel[i]) in += A[i] + sel[i];
			}
			if (gyu > in) win++;
			if (in > gyu) lose++;
			return;
		}

		for (int i = 0; i < 9; i++) {
			if (!visited[i]) {
				visited[i] = true;
				sel[idx] = B[i];
				dfs(idx + 1);
				visited[i] = false;
			}
		}
	}
}
