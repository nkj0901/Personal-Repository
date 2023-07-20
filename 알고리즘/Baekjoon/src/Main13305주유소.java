import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main13305주유소 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        long[] dist = new long[N];
        long answer = 0;

        for(int i = 1; i < N; i++){
            dist[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        long[] city = new long[N+1];
        long minCost = Long.MAX_VALUE;
        for(int i = 1; i < N; i++){
            city[i] = Integer.parseInt(st.nextToken());

            if(minCost > city[i]) {
                answer+=city[i]*dist[i];
                minCost=city[i];
            } else {
                answer+=minCost*dist[i];
            }
        }
        System.out.println(answer);
    }
}
