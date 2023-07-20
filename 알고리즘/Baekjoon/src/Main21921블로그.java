import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main21921블로그 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int sum = 0;
        int count = 1;

        for(int i = 0; i < X; i++){
            sum+=arr[i];
        }

        int max = sum;

        for(int i = 0; i < N-X; i++){
            sum-=arr[i];
            sum+=arr[i+X];
            if( sum > max){
                count = 1;
                max = sum;
            } else if(sum == max) count++;
        }

        if(max == 0) System.out.println("SAD");
        else System.out.println(max + " " + count);
    }
}
