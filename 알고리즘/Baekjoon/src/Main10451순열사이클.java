import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main10451순열사이클 {
    static boolean[] visited;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int t = 0; t < T; t++) {

            int N = Integer.parseInt(br.readLine());
            arr = new int[N + 1];
            int answer = 0;

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            visited = new boolean[N + 1];

            for (int i = 1; i <= N; i++) {
                if (visited[i]) continue;
                visited[i] = true;
                dfs(i, arr[i]);
                answer++;
            }
            System.out.println(answer);
        }
    }
    private static void dfs(int start, int next){
        if(start == next) return;
        visited[next] = true;
        dfs(start, arr[next]);
    }
}
