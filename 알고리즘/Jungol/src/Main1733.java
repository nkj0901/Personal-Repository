import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main1733 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int[][] arr = new int[21][21];

		// 배열채우기
		for (int i = 1; i < 20; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j < 20; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int r = 0;
		int c = 0;
		int winner = 0;

		// 배열 순회하면 같은 수가 있는지 보기
		loop: for (int i = 1; i < 20; i++) {
			for (int j = 1; j < 20; j++) {

				if (arr[i][j] != 0) {

					// 가로 보기
					int cnt = 1;
					while (arr[i][j - 1] != arr[i][j] && arr[i][j + cnt] == arr[i][j]) {
						cnt++;
					}
					
					if (cnt == 5) {
						r  = i;
						c = j;
						winner = arr[i][j];
						break loop;
					}

					// 세로보기
					cnt = 1;
					while (arr[i-1][j] != arr[i][j] && arr[i + cnt][j] == arr[i][j]) {
						cnt++;
					}

					if (cnt == 5) {
						r  = i;
						c = j;
						winner = arr[i][j];
						break loop;
					}
					
					// '\'대각선 보기
					cnt = 1;
					while (arr[i-1][j-1] != arr[i][j] && arr[i + cnt][j + cnt] == arr[i][j]) {
						cnt++;
					}

					if (cnt == 5) {
						r  = i;
						c = j;
						winner = arr[i][j];
						break loop;
					}
					
					// '/' 대각선 보기
					cnt = 1;
					while (arr[i+1][j-1] != arr[i][j] && arr[i - cnt][j + cnt] == arr[i][j]) {
						cnt++;
					}

					if (cnt == 5) {
						r  = i;
						c = j;
						winner = arr[i][j];
						break loop;
					}
				}
			}
		}
		if (winner == 0)
			bw.append("0");
		else bw.append(winner + "\n" + r + " " + c);
		bw.flush();
		br.close();
		bw.close();
	}
} // main
