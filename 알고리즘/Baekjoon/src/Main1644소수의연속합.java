import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main1644소수의연속합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        boolean[] pn = new boolean[N+1];
        pn[0] = pn[1] = true;

        //소수만들기
        for(int i = 2; i <= Math.sqrt(N); i++) {
            if(pn[i]) continue;
            for(int j = i*i; j <= N; j+=i) {
                pn[j] = true;
            }
        }
        List<Integer> list = new ArrayList<>();
        for(int i = 2; i <= N; i++){
            if(!pn[i]) {
                list.add(i);
            }
        }

        int l = 0;
        int r = 0;
        if(N == 1) {
            System.out.println(0);
            return;
        }
        int sum = list.get(0);
        int answer = 0;

        while(l<=r && r < list.size()) {

            if(sum > N) {
                sum-=list.get(l);
                l++;
            } else if (sum < N) {
                r++;
                if(r >= list.size()) break;
                sum+=list.get(r);
            } else {
                answer++;
                sum-=list.get(l);
                l++;
                r++;
                if(r >= list.size()) break;
                sum+=list.get(r);
            }
        }
        System.out.println(answer);
    }
}
