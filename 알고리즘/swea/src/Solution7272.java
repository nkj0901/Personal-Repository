import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution7272 {
	
	static public int func(char x) {
		if (x == 'A' || x == 'D'|| x == 'O' || x == 'P' || x == 'Q' || x == 'R') {
			return 1;
		} else if (x == 'B') return 2;
		else return 3;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			String ans = "SAME";

			StringTokenizer st = new StringTokenizer(br.readLine());
			String str1 = st.nextToken();
			String str2 = st.nextToken();

			if (str1.length() == str2.length()) {
				for (int i = 0; i < str1.length(); i++) {
					if (func(str1.charAt(i)) != func(str2.charAt(i))) {
						ans = "DIFF";
					} 
				}
			} else ans = "DIFF"; //단어 길이가 같지 않은면  diff
			bw.append("#"+t+" "+ans+"\n");
		}
		bw.flush();
		br.close();
		bw.close();
	}
}
