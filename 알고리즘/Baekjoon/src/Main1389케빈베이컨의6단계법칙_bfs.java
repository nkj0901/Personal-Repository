import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main1389케빈베이컨의6단계법칙_bfs {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<Integer>[] list = new List[N + 1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            list[s].add(e);
            list[e].add(s);
        }
        int answer = 0;
        int min = Integer.MAX_VALUE;
        Queue<Node> queue = new LinkedList<>();
        int cabinNum;
        boolean[] check;

        for (int i = 1; i <= N; i++) {
            check = new boolean[N + 1];
            cabinNum = 0;
            queue.add(new Node(i, 0));

            while (!queue.isEmpty()) {
                Node n = queue.poll();
                List<Integer> curList = list[n.e];
                for (int l = 0; l < curList.size(); l++) {
                    if(check[curList.get(l)]) continue;
                    check[curList.get(l)] = true;
                    cabinNum+=n.cnt+1;
                    queue.add(new Node(curList.get(l), n.cnt+1));
                }
            }

            if(cabinNum < min) {
                min = cabinNum;
                answer = i;
            }
        }
        System.out.println(answer);
    }

    static class Node {
        int e, cnt;

        Node(int e, int cnt) {
            this.e = e;
            this.cnt = cnt;
        }
    }
}
