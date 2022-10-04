import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution8741두문자어 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			
			String ans = "";
			for(int i = 0; i < 3; i++) {
				String str = st.nextToken();
				char tmp =(char) (str.charAt(0)-32);
				ans+=tmp;
			}
			System.out.println("#" + t + " " + ans);
		}
	}
}
