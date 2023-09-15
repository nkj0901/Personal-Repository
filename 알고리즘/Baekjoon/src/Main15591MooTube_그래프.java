import java.io.*;
import java.util.*;

public class Main15591MooTube_그래프 {

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
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        List<Node>[] list = new List[N+1];
        for(int i = 1; i <= N; i++){
            list[i] = new ArrayList<>();
        }

        for(int i = 0; i < N-1; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            list[s].add(new Node(e, w));
            list[e].add(new Node(s, w));
        }

        for(int q = 0; q < Q; q++) {
            st = new StringTokenizer(br.readLine());
            boolean[] visited = new boolean[N+1];
            Queue<Node> queue = new LinkedList<>();

            int K = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());

            queue.add(new Node(V, Integer.MAX_VALUE));
            int answer = 0;

            while(!queue.isEmpty()){
                Node cur = queue.poll();
                visited[cur.e] = true;

                for(int i = 0; i < list[cur.e].size(); i++){
                    Node next = list[cur.e].get(i);
                    if(!visited[next.e] && Math.min(cur.w, next.w) >= K) {
                        answer++;
                        queue.add(new Node(next.e, Math.min(cur.w, next.w)));
                    }
                }
            }
            bw.write(answer+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
