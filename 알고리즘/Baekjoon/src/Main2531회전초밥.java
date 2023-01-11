import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main2531회전초밥 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 회전초밥 벨트에 놓인 접시의 수
        int d = Integer.parseInt(st.nextToken()); // 초밥의 가짓수
        int k = Integer.parseInt(st.nextToken()); // 연속해서 먹는 접시 수
        int c = Integer.parseInt(st.nextToken()); // 쿠폰번호

        int[] arr = new int[N];

        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int[] count = new int[d+1];
        for(int i = 0; i < k; i++) {
            count[arr[i]]++;
        }
        count[c]++;

        int cnt = 0;
        for(int i = 1; i <= d; i++) {
            if(count[i] >= 1) cnt++;
        }

        int max = cnt;

        for(int i = 1; i < N; i++) {
            cnt = 0;
            count[arr[i-1]]--;
            count[arr[(i+k-1)%N]]++;
            for(int j = 1; j <= d; j++) {
                if( count[j] >= 1) cnt++;
            }
            max = Math.max(max, cnt);
        }
        System.out.println(max);
    }
}
