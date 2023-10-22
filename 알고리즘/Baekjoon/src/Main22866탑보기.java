import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main22866탑보기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] towers = new int[N];
        for(int i = 0; i < N; i++) {
            towers[i] = Integer.parseInt(st.nextToken());
        }
        int[] idx = new int[N];
        Arrays.fill(idx, Integer.MAX_VALUE);
        int[] cnt = new int[N];

        Stack<Integer> stackL = new Stack<>();
        Stack<Integer> stackR = new Stack<>();

        for(int t = 0; t < N; t++) {
            //왼쪽
            if(!stackL.isEmpty()){
                while(!stackL.isEmpty()){
                    if(towers[stackL.peek()] <= towers[t]) stackL.pop();
                    else break;
                }
            }
            cnt[t] += stackL.size();
            if(!stackL.isEmpty()) {
                if(t-stackL.peek() <= Math.abs(t-idx[t])){
                    idx[t] = stackL.peek();
                }
            }
            stackL.add(t);

            int revIdx = N-t-1;
            if(!stackR.isEmpty()){
                while(!stackR.isEmpty()){
                    if(towers[stackR.peek()] <= towers[revIdx]) stackR.pop();
                    else break;
                }
            }
            cnt[revIdx] +=stackR.size();
            if(!stackR.isEmpty()) idx[revIdx] = stackR.peek()-revIdx < Math.abs(revIdx-idx[revIdx]) ? stackR.peek() : idx[revIdx];
            stackR.add(revIdx);
        }

        for(int i = 0; i < N; i++) {
            sb.append(cnt[i]);
            if(cnt[i] != 0) sb.append(" " + (idx[i]+1));
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
