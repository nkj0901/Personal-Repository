import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2512예산_이분탐색 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] nums = new int[N];
        int right = 0;
        int sum = 0;

        for(int i = 0; i < N; i++){
            int num = Integer.parseInt(st.nextToken());
            right = Math.max(num, right);
            nums[i] = num;
            sum+=num;
        }

        int total = Integer.parseInt(br.readLine());

        if(total >= sum) System.out.println(right);
        else {
            int left = 0;
            int mid = 0;
            while(left <= right){
                mid = (left+right)/2;
                sum = 0;
                for(int i = 0; i < N; i++){
                    if(nums[i] <= mid) sum+=nums[i];
                    else sum+=mid;
                }
                if(sum <= total) left = mid+1;
                else if(sum > total) right=mid-1;
            }
            System.out.println(right);
        }
    }
}
