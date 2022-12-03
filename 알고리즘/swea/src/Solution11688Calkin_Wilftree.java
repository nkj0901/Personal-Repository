import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution11688Calkin_Wilftree {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			int left = 1;
			int right = 1;
			
			String str = br.readLine();
			
			for (int i = 0; i < str.length(); i++) {
				if (str.charAt(i)=='L') {
					right = left + right;
				} else {
					left = left + right;
				}
			}
			bw.write("#" + t + " " + left + " " + right + "\n");
		}
		bw.flush();
		br.close();
		bw.close();
	}
}
