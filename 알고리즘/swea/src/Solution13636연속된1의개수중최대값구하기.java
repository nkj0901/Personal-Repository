import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution13636연속된1의개수중최대값구하기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			
			String str = br.readLine();
			int cnt = 0;
			int max = -1;
			for(int i = 0; i < str.length(); i++) {
				if(str.charAt(i)=='1') {
					cnt++;
				} else {
					cnt=0;
				}
				max=Math.max(max, cnt);
			}
			System.out.println("#" + t + " " + max);
		}
	}
}
