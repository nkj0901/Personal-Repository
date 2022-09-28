import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
 
public class 등산로 {
    static StringBuilder sb = new StringBuilder();
    static int N, K, ans;
    static int max;
    static int [][] map;
    static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
    static boolean [][] visited;
    static Queue<Integer> high = new LinkedList<>();
 
 
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= T; tc++){
            sb.append("#" + tc + " ");
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            map = new int[N][N];
            visited = new boolean[N][N];
            max = 0;
            ans = 0;
            for(int i = 0; i < N; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < N; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                    max = Math.max(max, map[i][j]);
                }
            }
 
            // 최고봉 인 것들 큐에 넣기
            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    if(map[i][j] == max){
                        visited[i][j] = true;
                        dfs(i, j, max,1, 0);
                        visited[i][j] = false;
                    }
                }
            }
            sb.append(ans).append("\n");
        }
        System.out.println(sb);
    }
 
    static void dfs(int x, int y, int height, int cnt, int cut){
 
        ans = Math.max(cnt, ans);
 
        for(int i = 0; i < 4; i++){
            int nr = x + dr[i];
            int nc = y + dc[i];
            // 범위 안에 있으면서 방문 체크 안 했을 경우
            if(nr >= 0 && nr < N && nc >= 0 && nc < N){
                if(!visited[nr][nc]) {
                	//더 낮은 곳이면 간다.
                    if (height > map[nr][nc]) {
                        visited[nr][nc] = true;
                        dfs(nr, nc, map[nr][nc],cnt + 1, cut);
                        visited[nr][nc] = false;
 
                    }
                    // 현재 높이보다 높거나 같고 깎을 수 있을 때
                    else {
                        if (cut == 0) {
                            if (height > map[nr][nc] - K) {
                                visited[nr][nc] = true;
                                dfs(nr, nc, height-1, cnt + 1, cut + 1);
                                visited[nr][nc] = false;
                            }
                        }
                    }
                }
            }
        }
    }
}

