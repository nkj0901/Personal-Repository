import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main12919A와B2_dfs {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		S = br.readLine();
		String T = br.readLine();

		ans = 0;
		dfs(T);

		System.out.println(ans);
	}

	static String S;
	static int ans;

	private static void dfs(String t) {

		if (t.length() == S.length()) {
			if (t.equals(S)) {
				ans = 1;
			}
			return;
		}

		// t의 앞자리가 B이면 앞자리 B를 없애고 뒤집는다.
		if( t.charAt(0) == 'B') {
			String tmp = t.substring(1);
			StringBuilder sb = new StringBuilder(tmp);
			tmp = sb.reverse().toString();
			dfs(tmp);
		}
		// 뒤에 A를 뺀다.
		if( t.charAt(t.length()-1) == 'A') {
			dfs(t.substring(0, t.length()-1));
		}
	}
}