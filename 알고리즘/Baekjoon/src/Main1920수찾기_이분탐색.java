import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main1920수찾기_이분탐색  {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] n = new int[N];

        st= new StringTokenizer(br.readLine());
        for(int i = 0; i< N; i++){
            n[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(n);

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < M; i++) {
            int cur = Integer.parseInt(st.nextToken());

            int left = 0;
            int right = N-1;
            int mid = 0;
            int check = 0;

            while(left <= right) {

                mid = (left+right)/2;

                if(n[mid] > cur) right = mid-1;
                else if(n[mid] < cur) left = mid+1;
                else {  check = 1; break; }
            }
            bw.write(check + "\n");
        }
            bw.flush();
            bw.close();
            br.close();
    }
}
