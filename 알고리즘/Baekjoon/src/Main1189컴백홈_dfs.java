import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1189컴백홈_dfs {
    static int R, C, K, answer;
    static int[] dr = {0, -1, 0, 1};
    static int[] dc = {-1, 0, 1, 0};
    static char[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        visited = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        answer = 0;
        visited[R - 1][0] = true;
        dfs(R - 1, 0, 1);
        System.out.println(answer);
    }

    private static void dfs(int r, int c, int cnt) {
        if (r == 0 && c == C - 1) {
            if (cnt == K) answer++;
            return;
        }

        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];

            if (nr < 0 || nc < 0 || nr >= R || nc >= C) continue;
            if (map[nr][nc] == 'T') continue;
            if (visited[nr][nc]) continue;
            visited[nr][nc] = true;

            dfs(nr, nc, cnt + 1);
            visited[nr][nc] = false;
        }
    }
}
