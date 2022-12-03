import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution5607조합 {
	static int mod = 1234567891;
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int R = Integer.parseInt(st.nextToken());
			
		long[] factorial = new long[1000001];
		factorial[1] = 1;
		for (int i = 2; i < 1000001; i++) {
			factorial[i] = factorial[i-1]*i % mod;
		}
		long a = factorial[N];
		long b = (factorial[N-R] * factorial[R])%mod;
		long ans = (a * (pow(b, mod-2)))%mod;
		
		bw.write("#" + t + " " + ans+"\n");
		}
		bw.flush();
		br.close();
		bw.close();
	}
	static long pow(long N, long M) {
		
		if (M == 1) return N;
		
		long result = pow(N, M/2);
		if (M%2==0) {
			return (result*result)%mod;
		} else {
			return ((result*result)%mod*N)%mod;
		}
	}
}
