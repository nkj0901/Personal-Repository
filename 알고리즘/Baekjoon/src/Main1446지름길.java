import java.io.*;
import java.util.*;

public class Main1446지름길 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        List<Node> list = new ArrayList<>();
        PriorityQueue<Node> pq = new PriorityQueue<>();

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            if(e > D) continue;
            if(e-s <= w) continue;
            list.add(new Node(s,e,w));
        }
        Collections.sort(list, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.s - o2.s;
            }
        });

        int answer = D;

        if(list.size() != 0) {
            pq.add(new Node(0,0,0));
        }

        while(!pq.isEmpty()){
            Node n = pq.poll();
            if( n.e == D ) {
                answer = n.w;
                break;
            }
            for(int i = 0; i < list.size(); i++){
                Node c = list.get(i);
                if(c.s >= n.e ) {
                    //지름길 이용
                    pq.add(new Node(c.s, c.e, c.w + n.w + (Math.abs(n.e-c.s))));
                }
            }
            //지름길 아무것도 안 이용
            pq.add(new Node(0, D, n.w + (D-n.e)));
        }

        System.out.println(answer);
    }

    static class Node implements Comparable<Node>{
        int s, e, w;

        Node(int s, int e, int w){
            this.s = s;
            this.e = e;
            this.w = w;
        }

        @Override
        public int compareTo(Node o1){
            return this.w - o1.w;
        }
    }
}

/*
4 200
150 200 50
100 200 30
1 200 210
2 100 50
* */