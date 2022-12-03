import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main1652 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());

		char[][] arr = new char[N][N];

		// 배열채우기
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				arr[i][j] = str.charAt(j);
			}
		}

		// 가로
		int ans1 = 0;
		for (int i = 0; i < N; i++) {
			int rcnt = 0;
			for (int j = 0; j < N; j++) {
				// 가로
				if (arr[i][j] == '.') {
					rcnt++;
				}
				if (arr[i][j] != '.' || j == N - 1) { 
					// 연속으로 없거나 배열의 마지막 인덱스일 때 .가 연속으로 몇번나왔는지 확인
					// 이전에 '.'이 연속으로 있던 횟수가 2가 넘는다면 ans1++
					if (rcnt >= 2)
						ans1++;
					rcnt = 0; //카운트 횟수 초기화
				}
			}
		}

		// 세로
		int ans2 = 0;
		for (int i = 0; i < N; i++) {
			int ccnt = 0;
			for (int j = 0; j < N; j++) {
				// 가로
				if (arr[j][i] == '.') {
					ccnt++;
				}
				if (arr[j][i] != '.' || j == N - 1) { 
					// 연속으로 없거나 배열의 마지막 인덱스일 때 .가 연속으로 몇번나왔는지 확인
					// 이전에 '.'이 연속으로 있던 횟수가 2가 넘는다면 ans2++
					if (ccnt >= 2)
						ans2++;
					ccnt = 0; //카운트 횟수 초기화
				}
			}
		}
		bw.write(ans1 + " " + ans2);
		bw.flush();
		br.close();
		bw.close();
	}
}
