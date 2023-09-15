import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class test {
    static public int solution(int N, int number) {
        // N을 x을 사용해서 만들 수 있는 수들을
        Set<Integer>[] dp = new Set[9];
        for(int i = 1; i < 9; i++){
            dp[i] = new HashSet<>();
        }
        for(int i = 1; i < 9; i++) {
            dp[i].add(Integer.parseInt(Integer.toString(N).repeat(i)));
        }

        //N을 i개 이용해서 만들 수 있는 모든 경우의 수 저장
        for(int i = 1; i < 9; i++){
            for(int j = 1; j < i; j++){

                for(int k : dp[j]){
                    for(int l : dp[i-j]){
                        dp[i].add(k+l);
                        dp[i].add(k-l);
                        dp[i].add(k*l);
                        if(l != 0) dp[i].add(k/l);
                    }
                }
            }
        }
        int answer = -1;
        for(int i = 0; i < 9; i++){
            if(dp[i].contains(number)) {
                answer = i;
                break;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(5, 12));
    }
}
