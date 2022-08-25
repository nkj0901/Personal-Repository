import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution1859 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		// 테스트케이스
		long T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {

			// 일수
			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[N];

			// 일별 가격받기
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			// 앞에 나보다 더 큰 수가 나올 때까지의 차익 계산
			long ans = 0;
			for (int i = arr.length - 1; i >= 1; i--) {
				int price = 0;
				int cnt = 0;
				for (int j = i-1; j >= 0; j--) {
					if (arr[i] > arr[j]) {
						price+=arr[i] - arr[j];
						cnt++;
					} else if (arr[i] <= arr [j]) {
						break;
					}
				}
				ans+=price;
				i = i-cnt;
			}
			// 일수별 가격
			bw.append("#" + tc + " " + ans);
			bw.newLine();
		}
		bw.flush();
		br.close();
		bw.close();
	}
}