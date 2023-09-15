import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main15681트리와쿼리_트리DP {
    static Node[] list;
    static int[] size;

    static class Node{
        List<Integer> link = new ArrayList<>();
        List<Integer> child = new ArrayList<>();
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        list = new Node[N+1];
        size = new int[N+1];

        for(int i = 1; i <= N; i++) {
            list[i] = new Node();
        }

        for(int i = 0; i < N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            list[s].link.add(e);
            list[e].link.add(s);
        }
        makeTree(R, -1);
        countSubtreeNodes(R);

        for(int q = 0; q < Q; q++) {
            int u = Integer.parseInt(br.readLine());
            sb.append(size[u] + "\n");
        }
        System.out.println(sb);
    }

    private static void makeTree(int currentNode, int parent) {
        List<Integer> link = list[currentNode].link;
        List<Integer> child = list[currentNode].child;
        for(int i = 0; i < link.size(); i++){
            if(link.get(i) != parent) {
                child.add(link.get(i));
                makeTree(link.get(i), currentNode);
            }
        }
    }

    private static void countSubtreeNodes(int u) {
        size[u] = 1;
        for(int i = 0; i < list[u].child.size(); i++) {
            countSubtreeNodes(list[u].child.get(i));
            size[u]+=size[list[u].child.get(i)];
        }
    }
}
