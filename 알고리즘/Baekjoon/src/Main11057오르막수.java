import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main11057오르막수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] dp = new int[N+1][10];

        //맨 첫줄은 1로 초기화
        for(int i = 0; i < 10; i++) {
            dp[0][i] = 1;
        }

        //i는 몇번째 자리수까지 보았는지
        for(int i = 1; i < N+1; i++){
            //j는 해당 자리수에 j를 놓았을 때의 경우를 보겠다는 뜻
            for(int j = 0; j < 10; j++) {

                //i-1번 자리수에 z가 들어갔을 때 경우의 수 구하기
                for(int z = j; z < 10; z++){
                    dp[i][j]+=dp[i-1][z];
                    dp[i][j] %= 10007;
                }
            }
        }
        System.out.println(dp[N][0]);
    }
}
