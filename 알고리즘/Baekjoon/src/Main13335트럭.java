import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main13335트럭 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int[] trucks = new int[n];
        for(int i = 0; i < n; i++){
            trucks[i] = Integer.parseInt(st.nextToken());
        }

        int[] bridge = new int[w];

        int answer = 0;
        int weight = 0;
        int idx = 0;

        while(idx < n){

            //한칸씩 옮겨주기
            answer++;
            if(bridge[w-1] > 0) weight-=bridge[w-1];
            for(int i = w-2; i >= 0; i--) bridge[i+1] = bridge[i];
            bridge[0] = 0;

            //다음 트럭 올릴 수 있다면 올려주기
            if(weight+trucks[idx] <= l){
                bridge[0] = trucks[idx];
                weight+=trucks[idx];
                idx++;
            }
        }

        answer += w;
        System.out.println(answer);
    }

}
