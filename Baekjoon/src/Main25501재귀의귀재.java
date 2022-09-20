import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main25501재귀의귀재 {
	static int ans2 = 0;

	public static int recursion(String str, int start, int end) {
		ans2 = ans2 + 1;

		if (start >= end) {
			return 1;
		}
		if (str.charAt(start) != str.charAt(end)) {
			return 0;
		}
		return recursion(str, start + 1, end - 1);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {
			ans2 = 0;
			String str = br.readLine();
			int ans1 = recursion(str, 0, str.length() - 1);

			System.out.println(ans1 + " " + ans2);
		}
	}
}
