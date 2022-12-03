import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution1213String {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		for (int t = 1; t <= 10; t++) {
			int N = Integer.parseInt(br.readLine());
			String str1 = br.readLine();
			String str2 = br.readLine();
			int cnt = 0;
			
			while(true) {
				if (str2.contains(str1)) {
					cnt++;
					int index = str2.indexOf(str1);
					str2 = str2.substring(index+str1.length());
				} else {
					break;
				}
			}
			bw.write("#" + t + " " + cnt+"\n");
		}
		bw.flush();
		br.close();
		bw.close();
	}
}
