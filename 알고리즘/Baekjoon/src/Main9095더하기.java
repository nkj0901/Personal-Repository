import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main9095더하기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {

			int n = Integer.parseInt(br.readLine());
			
			memo = new int[n+1];
			Arrays.fill(memo, -1);
			memo[0] = 1;
			memo[1] = 1;
			int ans = fivo(n);

			System.out.println(ans);
		}
	}
	static int[] memo;
	
	private static int fivo(int n) {
		
		if(n < 0) return 0;
		
		if(memo[n] != -1) {
			return memo[n];
		}
		//1선택, 2선택, 3선택
		return fivo(n-1)+fivo(n-2)+fivo(n-3);
	}
}
