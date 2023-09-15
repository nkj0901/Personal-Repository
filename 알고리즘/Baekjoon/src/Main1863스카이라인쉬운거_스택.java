import java.util.*;
import java.io.*;
public class Main1863스카이라인쉬운거_스택 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        int[] height = new int[N+1];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            height[i] = num;
        }

        for(int i = 0; i <= N; i++) {
            while(!stack.isEmpty() && stack.peek() > height[i]){
                stack.pop();
                answer++;
            }
            if(!stack.isEmpty() && stack.peek() == height[i]) continue;

            stack.add(height[i]);
        }
        System.out.println(answer);
    }
}
/*

12
1 1
2 2
5 1
6 3
8 1
11 0
15 2
22 1
23 0
24 1
25 2
26 0

14
1 1
2 2
5 1
6 3
8 1
11 0
15 2
22 1
23 0
24 1
25 2
26 0
27 1
28 2

13
1 1
2 2
5 1
6 3
8 1
11 0
15 2
22 1
23 0
24 1
25 2
27 1
28 0

10
1 1
2 2
5 1
6 3
8 1
11 0
15 2
17 3
20 2
22 1
 */
