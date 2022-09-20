import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Solution4012요리사 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {

			int N = Integer.parseInt(br.readLine());

			int[][] arr = new int[N][N];
			
			//배열채우기
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			//모든경우의 수 보기
			int ans = Integer.MAX_VALUE;
			for (int i = 0; i < (1 << N); i++) {
				int cnt = 0;
				List<Integer> ok = new ArrayList<Integer>();
				List<Integer> notOk = new ArrayList<Integer>();
				int okSum = 0;
				int notOkSum = 0;
				
				//해당 재료를 가지고 있는지 확인
				for (int j = 0; j < N; j++) {
					if ((i & (1 << j)) > 0) {
						cnt++;
						ok.add(j);
					} else {
						notOk.add(j);//재료 번호를 리스트에 담는다.
					}
				}
				//재료를 N/2개씩 가진 경우라면 맛 차이 계산해보기
				if (cnt == N / 2) {
					for (int a = 0; a < N / 2; a++) {
						for (int b = 0; b < N / 2; b++) {
							okSum += arr[ok.get(a)][ok.get(b)];
							notOkSum += arr[notOk.get(a)][notOk.get(b)];
						}
					}
					if (Math.abs(okSum-notOkSum) < ans) {
						ans = Math.abs(okSum-notOkSum);
					}
				}
			}
			bw.write("#" + t + " " + ans + "\n");
		}
		bw.flush();
		br.close();
		bw.close();
	}
}
