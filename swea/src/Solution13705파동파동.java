import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution13705파동파동 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			bw.write("#" + t + " ");

			st = new StringTokenizer(br.readLine());

			int N = Integer.parseInt(st.nextToken()); // 배열사이즈
			int M = Integer.parseInt(st.nextToken()); // 시작 위치 숫자
			int R = Integer.parseInt(st.nextToken())-1; // 시작행
			int C = Integer.parseInt(st.nextToken())-1; // 시작열
			int D = Integer.parseInt(st.nextToken()); // 증감

			int[][] arr = new int[N][N];
			arr[R][C] = M;

			int left = -1; // 어디서부터 볼 것인지
			int right = 1; // 어디까지 볼 것인지
			int increase = M; // 증감
			while (true) {

				increase += D;

				if (increase > 255)
					increase = 255;
				
				if(increase < 0) break;
				

				// 위, 오른쪽
				for (int j = left; j < right; j++) {
					if (R + left >= 0 && R + left < N && C + j >= 0 && C + j < N) {
						arr[R + left][C + j] = increase;
					}
					if (R + j >= 0 && R + j < N && C + right >= 0 && C + right < N) {
						arr[R + j][C + right] = increase;
					}
				}
				// 아래, 왼쪽
				for (int j = right; j > left; j--) {
					if (R + right >= 0 && R + right < N && C + j >= 0 && C + j < N) {
						arr[R + right][C + j] = increase;
					}
					if (R + j >= 0 && R + j < N && C + left >= 0 && C + left < N) {
					arr[R + j][C + left] = increase;
					}
				}
				
				left--;
				right++;
				
				if(R + left < 0 && R + right >= N && C +left < 0 && C+right >= N) break;
			}
			
			for(int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					System.out.print(arr[i][j]+" ");
				}
				System.out.println();
			}
			System.out.println();
			
			int sum = 0;
			for(int i = 0; i < N; i++) {
				sum = 0;
				for (int j = 0; j < N; j++) {
					sum+=arr[i][j];
				}
				bw.write(sum+" ");
			}
			bw.newLine();
		}
		bw.flush();
		br.close();
		bw.close();
	}
}
