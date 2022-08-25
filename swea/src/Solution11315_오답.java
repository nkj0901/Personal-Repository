import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution11315_오답 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// 테스트케이스
		int T = Integer.parseInt(br.readLine());

		// 배열만들기
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			char[][] arr = new char[N][N];
			for (int i = 0; i < N; i++) {
				String str = br.readLine();
				for (int j = 0; j < N; j++) {
					arr[i][j] = str.charAt(j);
				}
			}

			// 다섯개가 줄지어서 있는지 판단하기
			boolean five = false;

			// 대각선
			for (int i = 0; i < N; i++) {
				int right1 = 0; // 오른쪽 아래로 줄지어 내려가는 대각선 돌 개수(가운데 기준 오른쪽면)
				int right2 = 0; // 오른쪽 아래로 줄지어 내려가는 대각선 돌 개수(가운데 기준 왼쪽면)
				int left1 = 0; // 왼쪽 아래로 줄지어 내려가는 대각선 돌 개수(가운데 기준 오른쪽면)
				int left2 = 0; // 왼쪽 아래로 줄지어 내려가는 대각선 돌 개수(가운데 기준 왼쪽면)
				for (int j = 0; j < N; j++) {

					// '\' 대각선
					if (i + j < N) {
						if (arr[j][i + j] == 'o')
							right1++;
						else
							right1 = 0;
						if (arr[i + j][j] == 'o')
							right2++;
						else
							right2 = 0;
					}

					// '/' 대각선
					if (j + i < N && arr[j + i][N - 1 - j] == 'o')
						left1++;
					else
						left1 = 0;
					if (N - i - j - 1 >= 0 && arr[j][N - i - j - 1] == 'o')
						left2++;
					else
						left2 = 0;

				}
				if (right1 >= 5 || right2 >= 5 || left1 >= 5 || left2 >= 5) {
					five = true;
					break;
				}
			}

			// 수직 수평 확인
			if (five == false) {
				for (int i = 0; i < N; i++) {
					int vertical = 0; // 수직으로 줄지어 내려가는 돌 개수
					int horizon = 0; // 수평으로 줄지어 내려가는 돌 개수
					for (int j = 0; j < N; j++) {
						// 수직
						if (arr[j][i] == 'o')
							vertical++;
						else
							vertical = 0;

						// 수평
						if (arr[i][j] == 'o')
							horizon++;
						else
							horizon = 0;

					}
					if (vertical >= 5 || horizon >= 5) {
						five = true;
						break;
					}
				}
			}
			bw.append("#" + tc + " ");
			if (five == true)
				bw.append("YES");
			else
				bw.append("NO");
			bw.newLine();
		}
		bw.flush();
		br.close();
		bw.close();
	}
}
