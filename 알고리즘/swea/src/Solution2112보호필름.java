import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution2112보호필름 {
	static int[][] film;
	static int[][] filmcopy;
	static int D, W, K, ans;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {

			st = new StringTokenizer(br.readLine());
			D = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			film = new int[D][W];
			filmcopy = new int[D][W];

			for (int i = 0; i < D; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					film[i][j] = Integer.parseInt(st.nextToken());
					filmcopy[i][j] = film[i][j];
				}
			}
//			filmcopy = film; //이거 왜 안되지

			ans = Integer.MAX_VALUE;

			Test(0, 0);
			System.out.println("#" + t + " " + ans);
		}
	}

	// ABC뭘 선택했을 때 제일 좋은가 확인해보자
	private static void Test(int idx, int cnt) {

		if (idx == D) {
			loop: for (int j = 0; j < W; j++) {
				int tmp = 1;
				for (int i = 0; i < D - 1; i++) {
					if (filmcopy[i][j] == filmcopy[i + 1][j])
						tmp++;
					else
						tmp = 1;
					if (tmp >= K)
						continue loop;
				}
				return;
			}
			ans = Math.min(ans, cnt);
			return;
		}

		// 아무것도 선택하지 않기
		Test(idx + 1, cnt);
		// A주사 넣기
		put(idx, 0);
		// A선택함수
		Test(idx + 1, cnt + 1);
		// B주사 넣기 //A주사 놓은 자리에다가 놓는거니까 다시 없애줄 필요없음 덮어짐
		put(idx, 1);
		// B선택함수
		Test(idx + 1, cnt + 1);
		// B주사 빼기
		remove(idx);
	}

	private static void remove(int idx) {
		for (int i = 0; i < W; i++) {
			filmcopy[idx][i] = film[idx][i];
		}
	}

	// 약품 투약
	private static void put(int idx, int AB) {
		for (int i = 0; i < W; i++) {
			filmcopy[idx][i] = AB;
		}
	}
}
