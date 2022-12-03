import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution11315 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// 테스트케이스
		int T = Integer.parseInt(br.readLine());

		// 배열만들기
		for (int tc = 1; tc <= T; tc++) {
			bw.append("#"+ tc + " ");
			int N = Integer.parseInt(br.readLine());
			char[][] arr = new char[N][N];
			for (int i = 0; i < N; i++) {
				String str = br.readLine();
				for (int j = 0; j < N; j++) {
					arr[i][j] = str.charAt(j);
				}
			}
			boolean five = false;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (arr[i][j] == 'o') {
						
						//수직
						int cnt = 1;
						for (int x = 1; x <= 4; x++) {
							if (i+x < N && arr[i+x][j]=='o') {
								cnt++;
								if (cnt == 5) five = true;
							} else break;
						}
						cnt = 1;
						//수평
						for (int x = 1; x <= 4; x++) {
							if (j+x < N && arr[i][j+x]=='o') {
								cnt++;
								if (cnt == 5) five = true;
							} else break;
						}
						cnt = 1;
						// '\' 대각선
						for (int x = 1; x <=4; x++) {
							if (i+x < N && j+x <N && arr[i+x][j+x]=='o') {
								cnt++;
								if (cnt == 5) five = true;
							} else break;
						}
						cnt = 1;
						// '/' 대각선
						for (int x = 1; x <=4; x++) {
							if (i+x < N && j-x >= 0 && arr[i+x][j-x] == 'o') {
								cnt++;
								if (cnt == 5) five = true;
							} else break;
						}
					}
				}
			}
			if (five == true) {
				bw.append("YES");
			} else bw.append("NO");
			bw.newLine();
		}
		bw.flush();
		br.close();
		bw.close();
	}
}
