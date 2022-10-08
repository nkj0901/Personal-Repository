import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution3282Knapsack {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			int[][] arr = new int[N+1][K+1];
			
			int tmp, V, C;
			for(int i = 1; i <=N; i++) { //물건개수
				st = new StringTokenizer(br.readLine());
				V = Integer.parseInt(st.nextToken());
				C = Integer.parseInt(st.nextToken());
				for(int j = 0; j <= K; j++) {
					
					if(j-V >= 0)
					tmp = arr[i-1][j-V]+C;
					else tmp = 0;
					
					arr[i][j] = Math.max(arr[i-1][j], tmp);
				}
			}
			
//			for(int[] a : arr) {
//				System.out.println(Arrays.toString(a));
//			}
			
			System.out.println("#" + t + " " + arr[N][K]);
		}
	}
}
