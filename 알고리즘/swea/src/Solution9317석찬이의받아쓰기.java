import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution9317석찬이의받아쓰기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			String str = br.readLine();
			String str1 = br.readLine();
			int ans = 0;
			
			for(int i = 0; i < str.length(); i++) {
				if(str.charAt(i)==str1.charAt(i)) {
					ans++;
				}
			}
			bw.write("#" + t + " " + ans + "\n");
		}
		bw.flush();
		br.close();
		bw.close();
	}
}
