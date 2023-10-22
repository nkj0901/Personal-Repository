import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main14466소가길을건너간이유6 {
    static int[][][] road;
    static int[][] cow;
    static boolean[][] visited;
    static int[] dr = {0, -1, 0, 1};
    static int[] dc = {-1, 0, 1, 0};
    static int cnt, N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int answer = 0;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        cow = new int[N][N];
        //좌, 상, 우, 하 순으로 길 있는지 저장
        road = new int[N][N][4];

        for(int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            int r1 = Integer.parseInt(st.nextToken())-1;
            int c1 = Integer.parseInt(st.nextToken())-1;
            int r2 = Integer.parseInt(st.nextToken())-1;
            int c2 = Integer.parseInt(st.nextToken())-1;
            addRoad(r1, c1, r2, c2);
        }

        for(int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken())-1;
            int c = Integer.parseInt(st.nextToken())-1;
            cow[r][c] = 1;
        }


        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(cow[i][j] == 1) {
                    K--;
                    visited = new boolean[N][N];
                    cnt = 0;
                    cow[i][j] = 0;
                    dfs(i, j);
                    answer+=(K-cnt);
                }
            }
        }
        System.out.println(answer);
    }
    private static void addRoad(int r1, int c1, int r2, int c2) {
        //좌(r1, c1 기준)
        if(r1 - r2 == 0 && c1 - c2 == 1) {
            road[r1][c1][0] = 1;
            road[r2][c2][2] = 1;
            //상
        } else if(r1 - r2 == 1 && c1 - c2 == 0) {
            road[r1][c1][1] = 1;
            road[r2][c2][3] = 1;
            //우
        } else if(r1 - r2 == 0 && c1 - c2 == -1) {
            road[r1][c1][2] = 1;
            road[r2][c2][0] = 1;
            //하
        } else if(r1 - r2 == -1 && c1 - c2 == 0) {
            road[r1][c1][3] = 1;
            road[r2][c2][1] = 1;
        }
    }

    private static void dfs(int r, int c) {

        visited[r][c] = true;

        if(cow[r][c] == 1) {
            cnt++;
        }

        for(int i = 0; i < 4; i++) {
            if(road[r][c][i] == 1) continue;
            int nr = r + dr[i];
            int nc = c + dc[i];

            if(nr >= N || nc >= N || nc < 0 || nr < 0) continue;
            if(visited[nr][nc]) continue;
            dfs(nr, nc);
        }
    }
}
/*
4 3 3
2 2 2 3
3 3 3 2
3 3 2 3
3 3
2 2
2 3
*/