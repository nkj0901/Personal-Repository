import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main5972택배배송_다잌 {

    static class Node implements Comparable<Node> {
        int e, w;
        Node(int e, int w){
            this.e = e;
            this.w = w;
        }
        @Override
        public int compareTo(Node o) {
            return this.w-o.w;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<Node>[] list = new List[N+1];

        for(int i = 1; i <= N; i++){
            list[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            list[s].add(new Node(e, w));
            list[e].add(new Node(s, w));
        }

        int[] dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);


        PriorityQueue<Node> pq = new PriorityQueue<>();

        for(int i = 0; i < list[1].size(); i++){
            pq.add(list[1].get(i));
        }
        int answer = 0;
        boolean[] check = new boolean[N+1];
        while(!pq.isEmpty()){
            Node n = pq.poll();
            if(n.e == N) {
                answer = n.w;
                break;
            }

            if(check[n.e]) continue;
            check[n.e] = true;


            for(int i = 0; i < list[n.e].size(); i++){
                Node t = list[n.e].get(i);
                if(dist[t.e] > n.w + t.w) {
                    dist[n.e] = n.w + t.w;
                    pq.add(new Node(t.e, dist[n.e]));
                }
            }
        }
        System.out.println(answer);
    }
}
