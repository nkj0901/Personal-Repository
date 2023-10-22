import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main15649N과M3 {
    static int N,M;
    static int[] sel;
    static boolean[] visited;
    static int[] number;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        number = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            number[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(number);

        sel = new int[M];
        visited = new boolean[N];

        dfs(0);

        System.out.println(sb.toString());
    }
    private static void dfs(int idx) {
        if(idx == M) {
            for(int i = 0; i < M; i++) {
                sb.append(sel[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i = 0; i < N; i++) {
            if(visited[i])continue;
            visited[i] = true;
            sel[idx] = number[i];
            dfs(idx+1);
            visited[i] = false;
        }
    }
}
