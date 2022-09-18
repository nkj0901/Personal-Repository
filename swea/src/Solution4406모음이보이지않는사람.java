import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution4406모음이보이지않는사람 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			bw.write("#" + t + " ");
			String str = br.readLine();
			
			for (int i = 0; i < str.length(); i++) {
				char c = str.charAt(i);
				if ( c != 'a' && c != 'e' && c != 'o' && c != 'u' && c != 'i') {
					bw.write(c);
				}
			}
			bw.newLine();
		}
		bw.flush();
		br.close();
		bw.close();
	}
}
