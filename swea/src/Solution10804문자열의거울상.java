import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution10804문자열의거울상 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			StringBuffer sb = new StringBuffer();
			String str = br.readLine();
			
			for(int i = 0; i < str.length(); i++) {
				
				switch (str.charAt(i)) {
				case 'b':
					sb.append("d");
					break;
				case 'd':
					sb.append("b");
					break;
				case 'p':
					sb.append("q");
					break;
				case 'q':
					sb.append("p");
					break;
				default:
					break;
				}
			}
			
			sb.reverse();
			System.out.println("#" + t + " " + sb);
		}
	}
}
