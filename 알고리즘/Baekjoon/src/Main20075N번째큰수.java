import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main20075N번째큰수 {

    static class Node implements Comparable<Node> {
        int cur, pre , pr, pc;

        Node(int cur, int pre, int pr, int pc){
            this.cur = cur;
            this.pre = pre;
            this.pr = pr;
            this.pc = pc;
        }

        @Override
        public int compareTo(Node o){
            return o.pre - this.pre;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][N];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();

        //맨 마지막 줄에 있는 애들 넣기
        for(int i = 0; i < N; i++){
            pq.add(new Node(0, arr[N-1][i], N-1, i));
        }
        int answer = 0;
        int cnt = 0;
        while(true){
            Node n = pq.poll();
            cnt++;

            if( cnt == N ) {
                answer = n.pre;
                break;
            }

            if(n.pr-1 < 0) continue;

            pq.add(new Node(n.pre, arr[n.pr-1][n.pc], n.pr-1, n.pc));
        }

        System.out.println(answer);
    }
}
