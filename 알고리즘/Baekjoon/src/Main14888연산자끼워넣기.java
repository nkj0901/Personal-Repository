import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main14888연산자끼워넣기 {
    static int N, min, max;
    static int[] number;
    static int[] oper;
    static boolean[] visited;
    static int[] sel;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;


        N = Integer.parseInt(br.readLine());
        number = new int[N];
        oper = new int[N-1];
        visited = new boolean[N-1];
        sel = new int[N-1];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            number[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        int idx = 0;
        for(int i = 0; i < 4; i++) {
            int count = Integer.parseInt(st.nextToken());
            for(int j = 0; j < count; j++) {
                oper[idx] = i;
                idx++;
            }
        }
        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;
        perm(0);
        System.out.print(max + "\n" + min);
    }
    private static void perm(int idx) {
        if(idx == N-1){
            int sum = 0;
            cal();
            return;
        }

        for(int i = 0; i < N-1; i++) {
            if(visited[i]) continue;
            visited[i] = true;
            sel[idx] = oper[i];
            perm(idx+1);
            visited[i] = false;
        }
    }

    private static void cal() {
        int sum = number[0];
        for(int i = 0; i < N-1; i++) {
            switch (sel[i]){
                case 0 :
                    sum += number[i+1];
                    break;
                case 1 :
                    sum -= number[i+1];
                    break;
                case 2 :
                    sum *= number[i+1];
                    break;
                case 3 :
                    if(sum < 0) {
                        sum *= -1;
                        sum /= number[i+1];
                        sum *= -1;
                    } else sum/=number[i+1];
                    break;
            }
        }
        if(min > sum) min = sum;
        if(max < sum) max = sum;
    }
}
