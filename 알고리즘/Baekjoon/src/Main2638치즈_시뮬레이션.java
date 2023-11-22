import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main2638치즈_시뮬레이션 {
    static int[][] arr;
    static boolean[][] air;
    static int[] dr = {0,-1,0,1};
    static int[] dc = {-1,0,1,0};
    static int N, M;

    static class Node{
        int r, c;
        Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        air = new boolean[N][M];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 0;
        boolean check;
        while(true) {
            answer++;
            check = false;
            //내부공기와 외부공기 확인
            airCheck();

            for(int i = 0; i < N; i++) {
                for(int j = 0; j < M; j++) {
                    if(arr[i][j] == 1) {
                        check = true;
                        int cnt = 0;
                        for(int d = 0; d < 4; d++) {
                            int nr = i+dr[d];
                            int nc = j+dc[d];
                            if(nr >= N || nc >= M || nr < 0 || nc < 0) continue;
                            if(air[nr][nc]) cnt++;
                        }
                        if(cnt >= 2) arr[i][j] = 0;
                    }
                }
            }
            if(!check) break;

        }
        System.out.println(answer-1);
    }
    private static void airCheck() {
        Queue<Node> queue = new LinkedList<>();
        for(boolean[] a : air)
        Arrays.fill(a, false);

        queue.add(new Node(0,0));
        air[0][0] = true;

        while(!queue.isEmpty()){
            Node n = queue.poll();

            for(int d = 0; d < 4; d++) {
                int nr = n.r + dr[d];
                int nc = n.c + dc[d];

                if(nr >= N || nr < 0 || nc >= M || nc < 0) continue;
                if(arr[nr][nc] != 0) continue;
                if(air[nr][nc]) continue;
                air[nr][nc] = true;
                queue.add(new Node(nr, nc));
            }
        }
    }
}
