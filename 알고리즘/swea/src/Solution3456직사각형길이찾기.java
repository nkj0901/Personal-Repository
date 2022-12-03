import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution3456직사각형길이찾기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			
			int[] arr = new int[101];
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < 3; i++) {
				arr[Integer.parseInt(st.nextToken())]++;
			}
			
			int ans = 0;
			for(int i = 1; i < 101; i++) {
				if(arr[i] == 1 || arr[i] == 3) {
					ans = i;
				}
			}
			System.out.println("#" + t + " " + ans);
		}
	}
}
