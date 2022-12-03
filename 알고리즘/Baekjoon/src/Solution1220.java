import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution1220 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		for (int tc = 1; tc <= 10; tc++) {
			// 배열만들기
			int N = Integer.parseInt(br.readLine());
			int[][] arr = new int[N][N];

			// 배열에 값을 넣기
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int cnt = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					
					if (arr[i][j] == 2) {
						for (int z = i-1; z >= 0; z--) {

							// 바로 위가 1이 있더라도 바로 위가 B이면 중복되니까
							if (arr[z][j] == 2) {
								break;
							}
							
							if (arr[z][j] == 1) {
								cnt++;
								break;
							}
						}
					}
				}
			}
			bw.append("#" + tc + " " + cnt);
			bw.newLine();
		}
		bw.flush();
		br.close();
		bw.close();
	}
}
