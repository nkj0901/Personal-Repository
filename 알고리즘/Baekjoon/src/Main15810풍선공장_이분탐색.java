import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main15810풍선공장_이분탐색 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        long answer = 0;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] time = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            time[i] = Integer.parseInt(st.nextToken());
        }
        long l = 0;
        long r = 1000000000000L;
        long mid = 0;
        long cnt = 0;
        while(l <= r){
            mid = (l+r)/2;
            cnt = 0;
            for(int i = 0; i < N; i++){
                cnt+=mid/time[i];
            }
            if(cnt >= M) r = mid-1;
            else l = mid+1;
        }

        System.out.println(l);
    }
}
