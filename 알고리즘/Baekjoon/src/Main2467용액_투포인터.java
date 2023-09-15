import java.io.*;
import java.util.*;

public class Main2467용액_투포인터 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];

        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int l = 0;
        int r = N-1;
        int sum;
        int min = Integer.MAX_VALUE;
        int lv = 0;
        int rv = 0;

        while(l < r) {
            sum = arr[l]+arr[r];

            if(min > Math.abs(sum)){
                min = Math.abs(sum);
                lv = l;
                rv = r;
            }

            if(sum < 0) l++;
            else if(sum > 0) r--;
            else  break;

        }
        System.out.println(arr[lv] + " " +  arr[rv]);
    }
}
