import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main17484진우의달여행 {

    static class Node{
        int dir, r, c, mount;

        Node(int dir, int r, int c, int mount){
            this.dir = dir;
            this.r = r;
            this.c = c;
            this.mount = mount;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][M];
        int[][] dp = new int[N][M];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        PriorityQueue<Node> pq = new PriorityQueue<>(((o1, o2) -> {return o1.mount-o2.mount;}));

        for(int i = 0; i < M; i++){
            pq.add(new Node(0, 0, i, arr[0][i]));
        }

        int answer = 0;

        loop : while(!pq.isEmpty()){
            Node n = pq.poll();

            for(int i = 1; i <=3; i++){
                int nr = n.r;
                int nc = n.c;

                if(n.dir == i) continue;
                else if(i == 1){
                    nr +=1;
                    nc -=1;
                } else if (i == 2) {
                    nr +=1;
                } else if (i == 3) {
                    nr +=1;
                    nc +=1;
                }
                if(nr == N) {
                    answer = n.mount;
                    break loop;
                }

                if(nc < 0 || nc >= M) continue;
                pq.add(new Node(i, nr, nc, n.mount+arr[nr][nc]));
            }
        }
        System.out.println(answer);
    }
}
