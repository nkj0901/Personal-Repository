import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution11736평범한숫자 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			
			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[N];
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			int cnt = 0;
			for(int i = 1; i < N-1; i++) {
				if ((arr[i-1] < arr[i] && arr[i+1] > arr[i])||(arr[i-1] > arr[i] && arr[i+1] < arr[i])) {
					cnt++;
				}
			}
			System.out.println("#" + t + " " + cnt);
		}
	}
}
