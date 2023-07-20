import java.io.*;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main19637if문좀대신써줘 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] power = new int[N];
        String[] name = new String[N];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            name[i] = st.nextToken();
            power[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < M; i++){
            int cur = Integer.parseInt(br.readLine());
            int l = 0;
            int r = N-1;

            while(l <= r) {
                int mid = (l+r)/2;
                if(power[mid] < cur) l = mid+1;
                else r = mid-1;
            }
            bw.write(name[l]+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
