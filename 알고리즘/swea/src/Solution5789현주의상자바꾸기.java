import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution5789현주의상자바꾸기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int Q = Integer.parseInt(st.nextToken());
			
			int[] arr = new int[N];
			
			for(int i = 1; i <= Q; i++) {
				st = new StringTokenizer(br.readLine());
				
				int L = Integer.parseInt(st.nextToken())-1;
				int R = Integer.parseInt(st.nextToken())-1;
				for(int j = L; j <= R; j++) {
					arr[j] = i;
				}
			}
			
			System.out.print("#" + t +  " ");
			for(int n : arr) {
				System.out.print(n + " ");
			}
			System.out.println();
		}
	}
}
