import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main14940쉬운최단거리 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N][M];
        Node start = new Node(0, 0);

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 2) {
                    start.r = i;
                    start.c = j;
                }
            }
        }
        int[][] dist = new int[N][M];
        for(int[] a : dist) Arrays.fill(a, Integer.MAX_VALUE);
        Queue<Node> queue = new LinkedList<>();

        queue.add(start);
        dist[start.r][start.c] = 0;

        int[] r = {-1, 0, 1, 0};
        int[] c = {0, 1, 0, -1};

        while (!queue.isEmpty()) {
            Node n = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nr = n.r+r[i];
                int nc = n.c+c[i];

                if(nr >= N || nr < 0 || nc < 0 || nc >= M) continue;
                if(dist[nr][nc] != Integer.MAX_VALUE) continue;
                if(arr[nr][nc] == 0) continue;

                dist[nr][nc] = dist[n.r][n.c]+1;

                queue.add(new Node(nr, nc));
            }
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(arr[i][j] == 0) dist[i][j] = 0;
                if(dist[i][j] == Integer.MAX_VALUE && arr[i][j] == 1) dist[i][j] = -1;
                bw.write(dist[i][j] + " ");
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static class Node {
        int r, c;

        Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
