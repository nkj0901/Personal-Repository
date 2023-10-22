import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1027고층건물_선분기울기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        int answer = 0;

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            int cnt = 0;
            double low = Double.MAX_VALUE;
            //왼쪽보기
            for (int l = i - 1; l >= 0; l--) {
                //기울기 구해보기
                double inclination = (double) (arr[i] - arr[l]) / (i - l);

                if (inclination < low) {
                    low = inclination;
                    cnt++;
                }
            }
            low = Double.MAX_VALUE;
            //오른쪽보기
            for (int r = i + 1; r < N; r++) {
                //기울기 구해보기
                double inclination = (double) (arr[i] - arr[r]) / (r - i);
                if (inclination < low) {
                    low = inclination;
                    cnt++;
                }
            }
            answer = Math.max(answer, cnt);
        }
        System.out.println(answer);
    }
}
