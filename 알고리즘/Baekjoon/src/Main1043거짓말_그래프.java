import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main1043거짓말_그래프 {
    static int[] parent;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<Integer>[] party = new List[M + 1];
        boolean[] check = new boolean[N + 1];

        //파티정보
        for (int i = 1; i <= M; i++) {
            party[i] = new ArrayList<>();
        }


        //누가 알고있는지 체크
        st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());

        for (int i = 0; i < t; i++) {
            check[Integer.parseInt(st.nextToken())] = true;
        }

        parent = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        //파티 정보 입력
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            for (int j = 0; j < num; j++) {
                int cur = Integer.parseInt(st.nextToken());
                party[i].add(cur);
                //사람들 연결
                if (j != 0) {
                    union(cur, party[i].get(j - 1));
                }
            }
        }

        //T인것을 찾아서 부모 노드가 같은 아이 다 T로 바꿔주기
        for (int i = 1; i <= N; i++) {
            if (check[i]) {
                int p = findSet(i);
                for (int j = 1; j <= N; j++) {
                    if (p == findSet(j)) {
                        check[j] = true;
                    }
                }
            }
        }

        //파티 정보를 보면서 F만 있으면 ans++;
        int ans = 0;
        loop:
        for (int i = 1; i <= M; i++) {
            for (int j = 0; j < party[i].size(); j++) {
                if (check[party[i].get(j)]) continue loop;
            }
            ans++;
        }
        System.out.println(ans);
    }

    public static int findSet(int x) {
        if (parent[x] != x) {
            parent[x] = findSet(parent[x]);
            return parent[x];
        } else return x;
    }

    public static void union(int x, int y) {
        parent[findSet(y)] = parent[findSet(x)];
    }
}
