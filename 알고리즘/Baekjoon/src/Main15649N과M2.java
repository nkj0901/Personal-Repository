import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main15649N과M2 {
    static int N,M;
    static int[] sel;
    static boolean[] visited;
    static List<String> list;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        sel = new int[M];
        visited = new boolean[N+1];
        list = new ArrayList<>();

        dfs(0, 0);

        System.out.println(sb);
    }
    private static void dfs(int idx, int cur) {
        if(idx == M) {
            for(int i = 0; i < M; i++) {
                sb.append(sel[i] + " ");
            }
            sb.append("\n");
            return;
        }

        for(int i = cur+1; i <= N; i++) {
            if(visited[i]) continue;
            visited[i] = true;
            sel[idx] = i;
            dfs(idx+1, i);
            visited[i] = false;
        }
    }
}
