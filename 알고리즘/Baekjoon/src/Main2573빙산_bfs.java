import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main2573빙산_bfs {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        arr = new int[r][c];

        for(int i = 0; i < r; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < c ; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        arr2 = new int[r][c];

        // 배열복사하기
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                arr2[i][j] = arr[i][j];
            }
        }

        int ans = 0;
        loop: while(true){

            visited = new boolean[r][c];

            //덩어리의 개수
            int cnt = 0;
            //배열 순회하면서 1이상인 애를 찾는다
            for(int i = 0; i < r; i++){
                for(int j = 0; j < c; j++){
                    if(arr[i][j] > 0 && !visited[i][j]){
                        bfs(i, j);
                        cnt++;
                        if(cnt > 1){
                            break loop;
                        }
                    }
                }
            }
            //덩어리가 없으면 == 덩어리가 모두 녹았으면 멈추기.
            if(cnt == 0) {
                ans = 0;
                break;
            }

            //배열 복사
            copyArr();

        ans++;
        }
        System.out.println(ans);
    }

    private static void copyArr() {
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                arr[i][j] = arr2[i][j];
            }
        }
    }

    static int[][] arr, arr2;
    static int r, c;
    static boolean[][] visited;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    static class Node{
        int r,c;
        Node(int r, int c){
            this.r = r;
            this.c = c;
        }
    }

    private static void bfs(int i, int j) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(i, j));
        visited[i][j] = true;

    while(!queue.isEmpty()){

        Node n = queue.poll();

        for(int d = 0; d < 4; d++){

            int nr = n.r+dr[d];
            int nc = n.c+dc[d];

            if(nr >= r || nc >= c || nr < 0 || nc < 0) continue;
            if(arr[nr][nc] <= 0) {
                arr2[n.r][n.c]--;
                continue;
            }
            if(visited[nr][nc]) continue;
            visited[nr][nc] = true;

            queue.add(new Node(nr, nc));
        }
    }

    }
}
