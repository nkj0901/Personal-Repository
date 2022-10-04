import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution1216회문2 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int t = 1; t <= 10; t++) {
			int T = Integer.parseInt(br.readLine());
			char[][] arr = new char[100][100];

			// 배열채우기
			for (int i = 0; i < 100; i++) {
				String str = br.readLine();
				for (int j = 0; j < 100; j++) {
					arr[i][j] = str.charAt(j);
				}
			}

			// 완전탐색시작
			int cnt1 = 0; // 가로 cnt
			int cnt2 = 0; // 세로 cnt
			int ans = 0;
			// 자리 하나씩 다 볼거다 (가로 100줄, 세로 100줄 볼거다)
			for (int idx = 0; idx < 100; idx++) {

				for (int i = 0; i < 100; i++) { // start idx
					for (int j = i + 1; j < 100; j++) { // end idx

						// 가로보자
						//만약 같으면 안에도 똑같은지 봐봐
						if (arr[idx][i] == arr[idx][j]) {
							cnt1 = 1; //이미 같아서 들어왔으니 1부터 시작
							int start = i;
							int end = j;
							while (true) {
								start++;
								end--;
								if (start >= end) {
									if (start > end) { // 짝수이면
										ans = Math.max(ans, cnt1 * 2);
									} else { // 홀수이면
										ans = Math.max(ans, (cnt1 * 2 + 1));
									}
									break;
								}
								if (arr[idx][start] != arr[idx][end]) {
									break;
								}
								cnt1++;
							}

						}
						// 세로보자
						if (arr[i][idx] == arr[j][idx]) {
							cnt2 = 1; //이미 같아서 들어왔으니 1부터 시작
							int start = i;
							int end = j;
							while (true) {
								start++;
								end--;
								if (start >= end) {
									if (start > end) { // 짝수이면
										ans = Math.max(ans, cnt2 * 2);
									} else { // 홀수이면
										ans = Math.max(ans, ((cnt2 * 2) + 1));
									}
									break;
								}
								if (arr[start][idx] != arr[end][idx]) {
									break;
								}
								cnt2++;
							}
						}
					}
				}
			}
			if (ans == 0)
				ans = 1;
			System.out.println("#" + t + " " + ans);
		}

	}
}
