import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main10163 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// 색종이 개수 받기
		int T = Integer.parseInt(br.readLine());

		// 배열 만들기
		int[][] arr = new int[1001][1001];

		// 색종이 개수 만큼 위치 받기
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int start = Integer.parseInt(st.nextToken());
			int start1 = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());

			// 색종이 부분 0으로 우선 채우기
			// 색종이있는 곳 해당 숫자로 채우기
			for (int i = start; i < start + w; i++) {
				for (int j = start1; j < start1 + h; j++) {
					arr[i][j] = t;
				}
			}
		}
		// 색종이 순서대로 몇개 차지하고 있는지 출력
		for (int z = 1; z <= T; z++) {
			int cnt = 0;
			for (int i = 0; i < 1001; i++) {
				for (int j = 0; j < 1001; j++) {
					if (arr[i][j] == z) {
						cnt++;
					}
				}
			}
			bw.write(cnt + "");
			bw.newLine();
		}
		bw.flush();
		br.close();
		bw.close();
	}
}