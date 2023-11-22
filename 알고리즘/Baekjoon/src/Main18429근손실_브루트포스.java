import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main18429근손실_브루트포스 {
    static boolean[] visited;
    static int[] arr;
    static int N, K, answer;
    static int[] sel;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        visited = new boolean[N];
        sel = new int[N];
        answer = 0;

        perm(0, 500);

        System.out.println(answer);
    }

    static void perm(int idx, int weight){
        if(idx == N) {
            answer++;
            return;
        }

        for(int i = 0; i < N; i++) {
            if(visited[i]) continue;
            if(weight-K+arr[i] < 500) continue;
            visited[i] = true;
            sel[idx] = i;
            perm(idx+1, weight-K+arr[i]);
            visited[i] = false;
        }
    }
}
