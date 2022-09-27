import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution1240 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		String[] code = {"0001101", "0011001", "0010011", "0111101", "0100011", "0110001","0101111", "0111011", "0110111", "0001011"};
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			
			st = new StringTokenizer(br.readLine());
			int N  = Integer.parseInt(st.nextToken());
			int M  = Integer.parseInt(st.nextToken());
			
			for(int i = 0; i < N; i++) {
				String str = br.readLine();
				
			}
		}
	
	}
}
