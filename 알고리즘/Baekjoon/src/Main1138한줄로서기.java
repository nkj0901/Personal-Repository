import java.io.*;
import java.util.*;
public class Main1138한줄로서기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        Arrays.fill(arr, Integer.MAX_VALUE);
        st = new StringTokenizer(br.readLine());

        for(int i = 1; i <= N; i++) {
            int cnt = 0;
            int num = Integer.parseInt(st.nextToken());
            for(int j = 0; j < N; j++) {
                if(arr[j] > i) {
                    cnt++;
                    if(cnt == num+1) arr[j] = i;
                }
            }
        }
        for(int a : arr) System.out.print(a  + " ");
    }
}
