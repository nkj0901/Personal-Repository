import java.io.*;
import java.util.*;

public class Main13144listofuniquenumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        boolean[] check = new boolean[100001];
        long answer = 0;
        int l = 0;
        int r = 0;
        while(l < N) {
            while(r < N && !check[arr[r]]){
                check[arr[r]] = true;
                r++;
            }
            answer+=(r-l);
            check[arr[l]] = false;
            l++;
        }
        System.out.println(answer);
    }
}
