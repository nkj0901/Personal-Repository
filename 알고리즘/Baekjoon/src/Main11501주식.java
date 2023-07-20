import java.io.*;
import java.util.*;
public class Main11501주식 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int t = 0; t < T; t++) {

            int N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            int[] arr = new int[N];
            for(int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            int idx = N-1;
            long answer = 0;

            for(int i = N-1; i >= 0; i--) {
                if (arr[idx] < arr[i]){
                    idx = i;
                } else if (arr[idx]>arr[i]) {
                    answer+=arr[idx]-arr[i];
                }
            }
            System.out.println(answer);
        }//tc
    }
}
