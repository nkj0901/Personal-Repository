import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2747피보나치수_DP {
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        dp = new int[N+1];
        dp[1] = 1;
        System.out.println(fivo(N));
    }
    public static int fivo(int n){
        if(n <= 1) return n;

        if(dp[n] > 0) return dp[n];

        dp[n] = fivo(n-2) + fivo(n-1);
        return dp[n];
    }
}
