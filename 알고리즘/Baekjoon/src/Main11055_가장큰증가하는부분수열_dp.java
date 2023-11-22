import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main11055_가장큰증가하는부분수열_dp {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] dp = new int[N];

        st = new StringTokenizer(br.readLine());
        arr[0] = Integer.parseInt(st.nextToken());
        dp[0] = arr[0];
        int max = arr[0];
        for(int i = 1; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            dp[i] = arr[i];
            for(int j = i-1; j >= 0; j--) {
                if(arr[j] < arr[i]) {
                    dp[i] = Math.max(dp[j]+arr[i], dp[i]);
                }
            }
            if(max < dp[i]) max = dp[i];
        }
//        System.out.println(Arrays.toString(dp));
        System.out.println(max);
    }
}
/*
8
1 3 5 7 2 4 6 8
24

5
10 90 20 80 100
210

5
50 40 30 20 10
50

5
1 1 100 200 300
601

2
1 1
1

8
100 1 2 60 50 3 6 5
100

4
32 11 22 31
61

*/
