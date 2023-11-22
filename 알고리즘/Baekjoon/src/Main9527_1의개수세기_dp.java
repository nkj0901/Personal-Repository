import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main9527_1의개수세기_dp {
    static long[] DP;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        dp();
        long result =  f(B) - f(A-1);
        System.out.println(result);
    }
    private static long f(long N) {
        long ans = N & 1;

        for(int i = 54; i > 0; i--) {
            if((N & (1L << i)) > 0L) {
                ans+=DP[i-1] + (N-(1L << i)+1);
                System.out.println(N + " " + i + " " + DP[i-1] + " " + (N-(1L << i)+1));
                N-= (1L << i);
            }
        }
        return ans;
    }

    private static void dp(){
        DP = new long[55];
        DP[0] = 1;
        for(int i = 1; i < 55; i++) {
            DP[i] = 2 * DP[i-1] + (1L << i);
        }
        System.out.println(Arrays.toString(DP));
    }
}
