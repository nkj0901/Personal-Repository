import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution1860 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// 테스트케이스
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()); // 손님 수
			int M = Integer.parseInt(st.nextToken()); // 걸리는 시간
			int K = Integer.parseInt(st.nextToken()); // 만드는 개수
			int B = 0; // 붕어빵 개수
			int P = 0; // 붕어빵 받은 사람 수
			
			// 손님오는 시간 받아서 배열로 만들기
			int[] arr = new int[N];
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[j] = Integer.parseInt(st2.nextToken()); // 손님이 오는 시간
			}
			
			Arrays.sort(arr);

			// 포문이 돌 때마다 1초가 지난다고 생각
			loop: for (int i = 1; P != N ; i++) {
				// 걸리는 시간이 지나가면 붕어빵 갯수 ++
				if (i % M == 0)
					B += K;

				// 첫번째 오는 사람부터 마지막 사람까지 지금 지난 초와 오는 시간이 같으면 븡어빵 주는데 붕어빵이 없으면 impossible
				for (int j = P; j < N; j++) {
					if (arr[j] == i) {
						B--;
						P++;
						if (B < 0) {
							bw.write("#" + t + " " + "Impossible");
							bw.newLine();
							break loop;
						}
					}
				}
			}
			if (B >= 0) {
				bw.write("#" + t + " " + "Possible");
				bw.newLine();
			}
		}
		bw.flush();
		br.close();
		bw.close();
	}
}
