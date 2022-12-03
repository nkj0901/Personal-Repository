import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;

public class Solution7728다양성측정 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			Set<Integer> set = new HashSet<>();
			String str = br.readLine();
			
			for (int i = 0; i < str.length(); i++) {
				set.add(str.charAt(i)-'0');
			}
			bw.write("#" + t + " " + set.size()+"\n");
		}
		bw.flush();
		br.close();
		bw.close();
	}
}
