import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main16236아기상어_시뮬레이션 {

    static class Node{
        int r, c, time, eat;
        Node(int r, int c, int time, int eat) {
            this.r = r;
            this.c = c;
            this.time = time;
            this.eat = eat;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if(o1.time != o2.time) return o1.time-o2.time;
                else {
                    if(o1.r == o2.r){
                        return o1.c-o2.c;
                    } else {
                        return o1.r-o2.r;
                    }
                }
            }
        });

        int[][] arr = new int[N][N];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                int num = Integer.parseInt(st.nextToken());
                if(num == 9) {
                    pq.add(new Node(i, j, 0, 0));
                } else arr[i][j] = num;
            }
        }

        boolean[][] visited = new boolean[N][N];
        int[] dr = {-1, 0, 0, 1}; //위 왼 오 아
        int[] dc = {0, -1, 1, 0};

        int size = 2;
        int eat = 0;
        int eat2 = 0;
        int time = 0;

        while(!pq.isEmpty()){
            Node n = pq.poll();

            if(n.eat < eat2) continue;
            if(visited[n.r][n.c]) continue;
            visited[n.r][n.c] = true;

            //먹을 수 있는 물고긴지 확인
            if(arr[n.r][n.c] != 0 && arr[n.r][n.c] < size) {
                eat++;
                eat2++;
                n.eat++;
                arr[n.r][n.c] = 0;
                time+=n.time; n.time = 0;
                for(boolean[] v : visited) Arrays.fill(v, false);
                if(size == eat) {
                    size++;
                    eat = 0;
                }
            }

            for(int i = 0; i < 4; i++) {
                int nr = n.r + dr[i];
                int nc = n.c + dc[i];

                if(nr >= N || nc >= N || nr < 0 || nc < 0) continue;
                if(arr[nr][nc] > size) continue;

                pq.add(new Node(nr, nc, n.time+1, n.eat));
            }
        }
//        for(int[] a : arr)
//        System.out.println(Arrays.toString(a));
        System.out.println(time);
    }
}
