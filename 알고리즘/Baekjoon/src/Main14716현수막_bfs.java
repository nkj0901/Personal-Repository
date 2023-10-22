import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main14716현수막_bfs {
    static int[][] arr;
    static int[] dr = {0, -1, -1, -1, 0, 1, 1, 1};
    static int[] dc = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int R, C;

    static class Node{
        int r, c;
        Node(int r, int c){
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int answer = 0;

        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        arr = new int[R][C];

        for(int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < C; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < R; i++) {
            for(int j = 0; j < C; j++) {
                if(arr[i][j] == 1) {
                    bfs(i, j);
                    answer++;
                }
            }
        }
        System.out.println(answer);
    }

    private static void bfs(int i, int j) {

        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(i, j));
        arr[i][j] = 0;

        while(!queue.isEmpty()) {
            Node n = queue.poll();

            for(int d = 0; d < 8; d++) {
                int nr = n.r + dr[d];
                int nc = n.c + dc[d];

                if(nr < 0 || nc < 0 || nc >= C || nr >= R) continue;
                if(arr[nr][nc] != 1) continue;

                queue.add(new Node(nr, nc));
                arr[nr][nc] = 0;
            }
        }
    }
}
