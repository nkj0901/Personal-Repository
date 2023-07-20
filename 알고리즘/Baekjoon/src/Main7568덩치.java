import java.io.*;
import java.util.StringTokenizer;

public class Main7568덩치 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][2];
        int[] answer = new int[N];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(i == j) continue;

                if(arr[i][0] < arr[j][0] && arr[i][1] < arr[j][1]){
                    answer[i]++;
                }
            }
        }

        for(int i = 0; i < N; i++){
            bw.write(answer[i]+1 + " ");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
