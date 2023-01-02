import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1806부분합_투포인터 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());

		int[] arr = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		// 투포인터
		int start = 0;
		int end = 0;

		int sum = arr[0];
		int ans = Integer.MAX_VALUE;
		while (start < N) {

			// S가 넘으면 일단 몇개짜리 순열인지 저장하고 start 늘리기, 아직 넘지 않았으면 end 늘리기
			if (sum >= S) {
				ans = Math.min(ans, end - start + 1);
				sum -= arr[start];
				start++;
			} else if (end < N - 1) { // index가 N-1을 넘어가면 안되니까 더 N-1보다 작을 때만 늘려주자
				end++;
				sum += arr[end];
			} else { // end더 늘릴 수 없고 sum도 S가 넘지 않는다면 더 볼 필요가 없다.
				break;
			}
		}
		if (ans == Integer.MAX_VALUE)
			ans = 0;
		System.out.println(ans);
	}
}
