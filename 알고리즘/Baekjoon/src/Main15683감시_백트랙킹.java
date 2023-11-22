import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main15683감시_백트랙킹 {
    static int answer, N, M;
    static int[][] arr;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j< M; j++) {
                if(arr[i][j] == 5){
                    for(int d = 0; d < 4; d++) {
                        draw(i, j, d, -1);
                    }
                }
            }
        }

        answer = Integer.MAX_VALUE;
        cctv(0, 0);
        System.out.println(answer);
    }

    static void cctv(int r, int c) {

        int nr = r/M;
        int nc = c%M;
//        System.out.println(nr + " " + nc + " " + r + " " + c);
        if (nr == N) {
            //빈 곳 계산
//            for (int[] a : arr) System.out.println(Arrays.toString(a));
//            System.out.println();
            int cnt = 0;
            for(int i = 0; i < N; i++) {
                for(int j = 0; j <M; j++) {
                    if(arr[i][j] == 0) cnt++;
                }
            }
            answer = Math.min(answer, cnt);
            return;
        }

        if (arr[nr][nc] > 0 &&  arr[nr][nc] < 5) {
            switch (arr[nr][nc]) {
                case 1:
                    for (int d = 0; d < 4; d++) {
                        draw(nr, nc, d, -1);
                        cctv(r+1, c+1);
                        draw(nr, nc, d, 1);
                    }
                    break;
                case 2:
                    for (int d = 0; d < 2; d++) {
                        draw(nr, nc, d, -1);
                        draw(nr, nc, d + 2, -1);
                        cctv(r+1, c+1);
                        draw(nr, nc, d, 1);
                        draw(nr, nc, d + 2, 1);
                    }
                    break;
                case 3:
                    for (int d = 0; d < 4; d++) {
                        draw(nr, nc, d, -1);
                        draw(nr, nc, (d + 1) % 4, -1);
                        cctv(r+1, c+1);
                        draw(nr, nc, d, 1);
                        draw(nr, nc, (d + 1) % 4, 1);
                    }
                    break;
                case 4:
                    for (int d = 0; d < 4; d++) {
                        draw(nr, nc, d, -1);
                        draw(nr, nc, (d + 1) % 4, -1);
                        draw(nr, nc, (d + 2) % 4, -1);
                        cctv(r+1, c+1);
                        draw(nr, nc, d, 1);
                        draw(nr, nc, (d + 1) % 4, 1);
                        draw(nr, nc, (d + 2) % 4, 1);
                    }
                    break;
            }
        } else {
            cctv(r+1, c+1);
        }
    }

    static void draw(int r, int c, int d, int ox) {
        int n = 0;
        while (true) {
            n++;
            int nr = r + dr[d] * n;
            int nc = c + dc[d] * n;
            if (nr >= N || nc >= M || nr < 0 || nc < 0) break;
            if (arr[nr][nc] == 6) break;
            if (arr[nr][nc] > 0) continue;
            arr[nr][nc] += ox;
        }
    }
}
/*
5 5
5 1 6 1 4
6 0 1 6 3
2 5 0 0 0
0 6 0 0 0
6 0 6 6 6

3 1
5
6
0

4 4
1 2 3 4
0 0 0 5
0 0 0 0
0 0 0 0

3 3
0 0 0
0 3 0
0 0 0

5 5
5 0 0 0 5
0 0 0 0 0
0 0 4 0 0
0 0 0 0 0
5 0 0 0 5

4 5
0 0 2 0 4
0 6 0 0 0
0 0 6 6 0
0 0 0 0 0
*/