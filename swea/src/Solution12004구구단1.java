import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution12004구구단1 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t= 1; t <= T; t++) {
			
			int N = Integer.parseInt(br.readLine());
			
			boolean flag = false;
			for(int i = 1; i <= 9; i++) {
				if(N%i == 0 && N/i < 10) flag = true;
			}
			
			String ans = flag == true ? "Yes" : "No";
			
			System.out.println("#" + t + " " + ans);
		}
	}
}
