import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public interface Main20922겹치는건실어_투포인트 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] cnt = new int[100001];
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int l = 0;
        int r = 0;
        int count = 1;
        int answer = 0;
        cnt[arr[0]]++;
        while(r+1 < N){
            r++;
            cnt[arr[r]]++;
            count++;
            if(cnt[arr[r]] > K) {
                while(true){
                    cnt[arr[l]]--;
                    count--;
                    if(arr[l] == arr[r]) {
                        l++;
                        break;
                    }
                    l++;
                }
                continue;
            }
            answer = Math.max(count, answer);
        }
        System.out.println(answer);
    }
}
