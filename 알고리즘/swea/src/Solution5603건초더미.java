import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution5603건초더미 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {

			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[N];

			int sum = 0;
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(br.readLine());
				sum += arr[i];
			}

			int avg = sum / N;
			int ans = 0;

			for (int i = 0; i < N; i++) {
				if (avg > arr[i]) {
					ans += avg - arr[i];
				}
			}

			System.out.println("#" + t + " " + ans);
		}
	}
}
