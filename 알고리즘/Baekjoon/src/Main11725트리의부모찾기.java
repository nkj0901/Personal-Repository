import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main11725트리의부모찾기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        List<Integer>[] list = new ArrayList[N+1];

        for(int i = 1; i < N+1; i++){
            list[i] = new ArrayList<>();
        }

        //그래프 만들기
        for(int i = 1; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b);
            list[b].add(a);
        }

        //조회
        ans = new int[N+1];
        check = new boolean[N+1];

        dfs(1, list);

        //출력
        for(int i = 2; i < N+1; i++){
            System.out.println(ans[i]);
        }
    }
    static int[] ans;
    static boolean[] check;

    private static void dfs(int n, List<Integer>[] l) {
        List<Integer> list = l[n];
        for(int i = 0; i < list.size(); i++){
            if(check[list.get(i)]) continue;
            check[list.get(i)] = true;
            ans[list.get(i)] = n;
            dfs(list.get(i), l);
        }
    }
}
