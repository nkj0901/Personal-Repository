import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1149RGB거리 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][3];
		st = new StringTokenizer(br.readLine());
		arr[0][0] = Integer.parseInt(st.nextToken());
		arr[0][1] = Integer.parseInt(st.nextToken());
		arr[0][2] = Integer.parseInt(st.nextToken());

		int ans = 0;

		for (int i = 1; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Math.min(arr[i-1][1], arr[i-1][2]) + Integer.parseInt(st.nextToken());
			arr[i][1] = Math.min(arr[i-1][0], arr[i-1][2]) + Integer.parseInt(st.nextToken());
			arr[i][2] = Math.min(arr[i-1][0], arr[i-1][1]) + Integer.parseInt(st.nextToken());
		}

		int min = Math.min(Math.min(arr[N - 1][0], arr[N - 1][1]), arr[N - 1][2]);
		System.out.println(min);

	}
}
