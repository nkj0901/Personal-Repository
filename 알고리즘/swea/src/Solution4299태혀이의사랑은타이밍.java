import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;

public class Solution4299태혀이의사랑은타이밍 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			
			st = new StringTokenizer(br.readLine());
			int D = Integer.parseInt(st.nextToken())-11;
			int H = Integer.parseInt(st.nextToken())-11;
			int M = Integer.parseInt(st.nextToken())-11;
			
			int ans = (D*24*60)+(H*60)+(M);
			ans = ans < 0 ? -1:ans;
			System.out.println("#" + t + " " + ans);
		}
		
	}
}
