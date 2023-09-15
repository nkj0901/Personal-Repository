import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main17255N으로만들기 {
    static char[] arr;
    static Set<String> set;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arr = br.readLine().toCharArray();
        set = new HashSet<>();

        //idx 돌아가면서 시작 하는 애로 선택해보기
        for(int i = 0; i < arr.length; i++) {
            dfs(i, i, String.valueOf(arr[i]), String.valueOf(arr[i]));
        }

        System.out.println(set.size());
    }

    static void dfs(int l, int r, String s, String path){
        if(l == 0 && r == arr.length-1) {
            set.add(path);
            return;
        }
        if(l > 0) dfs(l-1, r, arr[l-1]+s, path + " " + arr[l-1] + s);
        if(r < arr.length-1) dfs(l, r+1, s+arr[r+1], path + " " + s + arr[r+1]);
    }
}
