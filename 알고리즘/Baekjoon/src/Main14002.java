import java.io.*;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main14002 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        int[] nums = new int[N];

        for(int i = 0; i < N; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }
        int[] dp = new int[N];
        int max = 1;

        int answer = 0;
        for(int i = 0; i < N; i++){
            dp[i] = 1;
            for(int j = 0; j < i; j++){
                if(nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                    max = Math.max(dp[i], max);
                }
            }
        }
        bw.write(max+"\n");

        Stack<Integer> stack = new Stack<>();
        for(int i = N-1; i >= 0; i--){
            if( dp[i] == max){
                max--;
                stack.add(nums[i]);
            }
        }

        while(!stack.isEmpty()){
            bw.write(stack.pop()+ " ");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
