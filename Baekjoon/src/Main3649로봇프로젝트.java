import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main3649로봇프로젝트 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		String input = "";

		while ((input = br.readLine()) != null && !input.isEmpty()) {

			int x = Integer.parseInt(input) * 10000000;
			int n = Integer.parseInt(br.readLine());
			int[] arr = new int[n];

			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(br.readLine());
			}
			Arrays.sort(arr);
			
			int max = Integer.MIN_VALUE;
			int ans1 = 0;
			int ans2 = 0;
			for (int i = 0; i < n-1 ; i++) {
				for (int j = i + 1; j < n; j++) {
					if(arr[i]+arr[j] == x) {
						if( max < Math.abs(arr[i]-arr[j])) {
							ans1 = arr[i];
							ans2 = arr[j];
							max = Math.abs(arr[i]-arr[j]);
						}
					}
				}
			}
			if( max == Integer.MIN_VALUE) {
				System.out.println("danger");
			} else {
				System.out.println("yes " + ans1 + " " + ans2);
			}
		}
	}
}
