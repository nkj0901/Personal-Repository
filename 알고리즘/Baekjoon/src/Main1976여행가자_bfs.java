import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main1976여행가자_bfs {
    static List<Integer>[] list;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String answer = "YES";

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        list = new List[N+1];

        for(int i = 0; i <= N; i++) {
            list[i] = new ArrayList<>();
        }


        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                if(Integer.parseInt(st.nextToken()) == 1) {
                    list[i+1].add(j+1);
                    list[j+1].add(i+1);
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        visited = new boolean[N+1];
        bfs(start);
        for(int i = 1; i < M; i++) {
            if(!visited[Integer.parseInt(st.nextToken())]){
                answer = "NO";
                break;
            }
        }
        System.out.println(answer);
    }

    private static void bfs(int num) {

        Queue<Integer> queue = new LinkedList<>();
        queue.add(num);

        while (!queue.isEmpty()) {
            int n = queue.poll();

            if(visited[n]) continue;
            visited[n] = true;

            for (int i = 0; i < list[n].size(); i++) {
                int cur = list[n].get(i);
                if(visited[cur]) continue;

                queue.add(cur);
            }
        }
    }
}
