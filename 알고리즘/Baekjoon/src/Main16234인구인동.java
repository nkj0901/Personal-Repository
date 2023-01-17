
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main16234인구인동 {

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

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        check = new boolean[N][N];

        //배열채우기
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        queue = new LinkedList<>();
        int ans = 0;

        //인구가 L이상 R이하이면 연합시키기
       while(true) {
           boolean isMove = false;
            check = new boolean[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (check[i][j] == true) continue;
                    list = new ArrayList<>();
                    int avg = bfs(i, j);
                    if(list.size()>1){
                        fill(avg);
                        isMove = true;
                    }
                }
            }
            if(!isMove) break;
            ans++;
        }
        System.out.println(ans);
    }


    static Queue<Node> queue;
    static List<Node> list;
    static int[][] map;
    static boolean[][] check;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static int N, L, R;

    private static boolean same() {
        int num = map[0][0];
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(map[i][j] != num) return false;
            }
        }
        return true;
    }

    private static void fill(int avg) {
        //채워주기
        for(int i = 0; i < list.size(); i++){
            Node nd = list.get(i);
            map[nd.r][nd.c] = avg;
        }
    }

    private static int bfs(int r, int c) {

        queue.add(new Node(r, c));
        list.add(new Node(r, c));
        int sum = map[r][c];
        check[r][c] = true;

        while(!queue.isEmpty()){
            Node n = queue.poll();

            for(int d = 0; d < 4; d++){
                int nr = dr[d] + n.r;
                int nc = dc[d] + n.c;
                
                if( nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
                int gap = Math.abs(map[nr][nc]-map[n.r][n.c]);
                if(gap >= L && gap <= R){
                	if(check[nr][nc]) continue;
                	check[nr][nc] = true;

                    list.add(new Node(nr, nc));
                    sum+=map[nr][nc];
                    queue.add(new Node(nr, nc));
                }
            }
        }
        //평균값구해주기
        int avg = sum/list.size();
        return avg;
    }
}
