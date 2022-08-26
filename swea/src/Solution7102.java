import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution7102 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		// 테스트케이스
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			bw.append("#" + tc + " ");

			// 입력값
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int[] Narr = new int[N + 1];
			int[] Marr = new int[M + 1];
			int[] count = new int[N + M + 1];

			// 1+N값을 담은 배열만들기
			for (int n = 1; n <= N; n++) {
				Narr[n] = n;
			}

			// 1+M값을 담은 배열만들기
			for (int m = 1; m <= M; m++) {
				Marr[m] = m;
			}

			// 다 더해서 카운팅 배열에 뭐가 몇번나왔는지 입력
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= M; j++) {
					count[Narr[i] + Marr[j]]++;
				}
			}

			// 출력 제일 큰 놈 찾아내기
			int max = 0;
			int index = 0;
			for (int i = 1; i <= N + M; i++) {
				if (count[i] > max) {
					max = count[i];
					index = i;
				}
			}
			bw.append(index + " ");

			// 나온 횟수가 같은 게 있을 수 있으니 찾아보기
			for (int i = 1; i <= N + M; i++) {
				if (count[i] == max && i != index) {
					bw.append(i + " ");
				}
			}
			bw.newLine();
		}
		bw.flush();
		br.close();
		bw.flush();
	}
}
