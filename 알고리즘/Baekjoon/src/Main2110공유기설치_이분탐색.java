import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main2110공유기설치_이분탐색 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];

        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int l = 1;
        int r = arr[N-1]-arr[0];

        while(l <= r) {
            int mid = (l+r)/2;
            int cnt = 1;
            int pre = 0;

            for(int i = 1; i < N; i++) {
                if(arr[i]-arr[pre] >= mid) {
                    cnt++;
                    pre = i;
                }
            }

            if(cnt < C) {
                r = mid - 1;
                continue;
            }
            l = mid + 1;
        }
        System.out.println(l-1);
    }
}
