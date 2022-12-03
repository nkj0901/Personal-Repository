import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main2503 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());

		int[][] arr = new int[N][3];
		int[][] ans = new int[N][2];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			arr[i][0] = str.charAt(0) - '0';
			arr[i][1] = str.charAt(1) - '0';
			arr[i][2] = str.charAt(2) - '0';
			ans[i][0] = Integer.parseInt(st.nextToken());
			ans[i][1] = Integer.parseInt(st.nextToken());
		}

		int A = 0;
		for (int hun = 1; hun <= 9; hun++) {
			for (int ten = 1; ten <= 9; ten++) {
				for (int one = 1; one <= 9; one++) {
					int cnt = 0;

					// 이 숫자가 주어진 숫자들과 비교했을 때, 스타라이크와 볼이 몇개인지 확인
					// 주어진 답과 수가 일치하면 정답 후보가 됨(cnt++)
					for (int i = 0; i < N; i++) {
						int strike = 0;
						int ball = 0;

						if (arr[i][0] == hun) {
							strike++;
						} else if (arr[i][0] == ten) {
							ball++;
						} else if (arr[i][0] == one) {
							ball++;
						}

						if (arr[i][1] == hun) {
							ball++;
						} else if (arr[i][1] == ten) {
							strike++;
						} else if (arr[i][1] == one) {
							ball++;
						}

						if (arr[i][2] == hun) {
							ball++;
						} else if (arr[i][2] == ten) {
							ball++;
						} else if (arr[i][2] == one) {
							strike++;
						}
						if (ans[i][0] == strike && ans[i][1] == ball) {
							cnt++;
						} else {
							break;
						}
					}
					if (cnt == N) {
						if (hun != ten && hun != one && ten != one)
						A++;
					}
				}
			}
		}
		bw.write(A + "");
		bw.flush();
		br.close();
		bw.close();
	}
}
