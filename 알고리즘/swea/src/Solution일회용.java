import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;

public class Solution일회용 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int k_min = Integer.parseInt(st.nextToken());
			int k_max = Integer.parseInt(st.nextToken());
			
			int[] arr = new int[N];
				
			int min = Integer.MAX_VALUE;
			int max = Integer.MIN_VALUE;
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
				min = Math.min(min, arr[i]);
				max = Math.max(max, arr[i]);
			}
			int ans = Integer.MAX_VALUE;
			for(int i = min; i < max; i++) {
				for(int j = i+1; j <= max; j++) {
					int A = 0;
					int B = 0; 
					int C = 0;
					
					for(int z = 0; z < N; z++) {
						
						if (arr[z] < i) C++;
						if (arr[z] >= i && arr[z] < j) B++;
						if (arr[z] >= j) A++;
					}
					
					if(C >= k_min && C <= k_max && B >= k_min && B <= k_max && A >= k_min && A <= k_max) {
						int tmpmin = Math.min(Math.min(C, B), A);
						int tmpmax = Math.max(Math.max(C, B), A);
						
						ans = Math.min(ans, tmpmax-tmpmin);
					}
				}
			}
			if(ans == Integer.MAX_VALUE) ans = -1;
			System.out.println("#" + t + " "+ ans);
			
		}
	}
}
