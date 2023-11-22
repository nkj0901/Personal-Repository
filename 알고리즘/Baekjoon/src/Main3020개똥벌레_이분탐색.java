import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main3020개똥벌레_이분탐색 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        int[] down = new int[N/2];
        int[] up = new int[N/2];

        for(int i = 0; i < N/2; i++) {
            down[i] = Integer.parseInt(br.readLine());
            up[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(down);
        Arrays.sort(up);


        int cnt = 0;
        int min = N;
        int sum;

        for(int i = 1; i < H+1; i++) {
            sum = binary(i, up) + binary(H-i+1, down);
            if(min==sum){
                cnt++;
            }
            else if(min>sum){
                min=sum;
                cnt=1;
            }
        }
        System.out.println(min + " " + cnt);
    }
    static int binary(int h, int[] arr) {
        int l = 0;
        int r = arr.length-1;
        int mid;

        while(l<=r){
            mid = (l+r)/2;

            if(arr[mid] >= h) r = mid-1;
            else l = mid+1;
        }

        return arr.length - l;
    }
}
