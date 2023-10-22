import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main9934완전이진트리_dfs {

    static List<Integer>[] list;
    static int[] arr;
    static int K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        K = Integer.parseInt(br.readLine());
        int N = (int)(Math.pow(2, K)-1);
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        list = new List[K];
        for(int i = 0; i < K; i++) {
            list[i] = new ArrayList<>();
        }

        dfs(0, N-1, 0);

        for(int i = 0; i < K; i++) {
            for(int j = 0; j < list[i].size(); j++){
                sb.append(list[i].get(j) + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void dfs(int start, int end, int cnt){
        if(K == cnt) return;

        list[cnt].add(arr[(start+end)/2]);

        dfs(start, (start+end)/2-1, cnt+1);
        dfs((start+end)/2+1, end, cnt+1);
    }
}
