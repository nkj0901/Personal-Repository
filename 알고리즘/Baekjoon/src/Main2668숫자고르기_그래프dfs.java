import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main2668숫자고르기_그래프dfs {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        arr = new int[N+1];

        for(int i = 1; i <= N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        list = new ArrayList<>();
        check = new boolean[N+1];
        for(int i = 1; i <= N; i++){
            check[i] = true;
            dfs(i, i);
            check[i] = false;
        }

        Collections.sort(list);
        System.out.println(list.size());
        for(int a : list) System.out.println(a);
    }

    static List<Integer> list;
    static boolean[] check;
    static int[] arr;

    public static void dfs(int s, int t){
        if(!check[arr[s]]){
            check[arr[s]] = true;
            dfs(arr[s], t);
            check[arr[s]] = false;
        }
        if(arr[s] == t) list.add(t);
    }
}
