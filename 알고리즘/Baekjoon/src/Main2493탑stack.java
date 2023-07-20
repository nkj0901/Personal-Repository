import java.io.*;
import java.util.*;

public class Main2493탑stack {

    static class Pair{
        int high;
        int index;

        Pair(int high, int index){
            this.high = high;
            this.index = index;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        Stack<Pair> stack = new Stack<>();
        int[] answer = new int[N];

        for(int i = 1; i <= N; i++) {
            int cur = Integer.parseInt(st.nextToken());
            while(true){
                if(stack.isEmpty()) {
                    stack.add(new Pair(cur, i));
                    bw.write("0 ");
                    break;
                } else {
                    Pair prev = stack.peek();
                    if(prev.high > cur) {
                        bw.write(prev.index + " ");
                        stack.add(new Pair(cur, i));
                        break;
                    } else stack.pop();
                }
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
