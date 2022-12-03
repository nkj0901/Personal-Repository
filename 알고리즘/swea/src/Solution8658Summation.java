import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution8658Summation {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			
			int max = 0;
			int min = Integer.MAX_VALUE;
			while(st.hasMoreElements()) {
				String str = (st.nextToken());
				int sum = 0;
				for (int i = 0; i < str.length(); i++) {
					sum+=str.charAt(i)-'0';
				}
				if (sum > max) {
					max = sum;
				}
				if (sum < min) {
					min = sum;
				}
			}
			bw.write("#" + t + " " + max + " " + min + "\n");
		}
		bw.flush();
		br.close();
		bw.close();
	}
}
