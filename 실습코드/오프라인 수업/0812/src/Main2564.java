import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main2564 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		// 사각형의 둘레를 구하기
		int width = Integer.parseInt(st.nextToken());
		int height = Integer.parseInt(st.nextToken());

		int circle = (width + height) * 2;

		int store = Integer.parseInt(br.readLine());

		int[] arr = new int[store + 1];
		for (int i = 0; i < store+1; i++) {
			StringTokenizer s = new StringTokenizer(br.readLine());
			int direction = Integer.parseInt(s.nextToken());
			int rocation = Integer.parseInt(s.nextToken());

			int distance = 0;
			// 원점으로부터의 거리
			if (direction == 1) // 북
				distance = rocation;
			else if (direction == 2)// 남
				distance = circle - height - rocation;
			else if (direction == 3) // 서
				distance = circle - rocation;
			else // 동
				distance = width + rocation;
			arr[i] = distance;

		}
		int ans = 0;// 총거리
		for (int i = 0; i < store; i++) {
			int sum1 = 0;// 시계방향
			int sum2 = 0;// 반시계방향
			sum1 = Math.abs(arr[i] - arr[store]);
			sum2 = circle - sum1;

			if (sum1 > sum2) {
				ans += sum2;
			} else {
				ans += sum1;
			}
		}
		System.out.println(ans);
	}
}
