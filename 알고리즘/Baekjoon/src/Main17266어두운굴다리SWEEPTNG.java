import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main17266어두운굴다리SWEEPTNG{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        int M = Integer.parseInt(br.readLine());
        int[] location = new int[M];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++){
            location[i] = Integer.parseInt(st.nextToken());
        }

        int n = location[0];
        for (int i = 1; i < M; i++) {
            int dist = location[i]-location[i-1];
            n = dist%2==0 ? Math.max(n, dist/2) : Math.max(n, dist/2+1);
        }
        n = Math.max(n, N-location[M-1]);
        System.out.println(n);
    }
}
