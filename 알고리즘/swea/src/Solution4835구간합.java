import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution4835구간합 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			
			st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			int[] arr = new int[N];
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			int max = 0;
			int min = Integer.MAX_VALUE;
			for(int i = 0; i < N-(M-1); i++) {
				int tmpAns = 0;
				for(int j = i; j < M+i; j++) {
					tmpAns+=arr[j];
				}
				max = Math.max(max, tmpAns);
				min = Math.min(min, tmpAns);
			}
			System.out.println("#" + t + " " + (max-min));
		}
	}
}
