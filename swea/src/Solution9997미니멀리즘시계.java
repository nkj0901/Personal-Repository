import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution9997미니멀리즘시계 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			int angle = Integer.parseInt(br.readLine());
			
			int h = angle/30;
			int m = angle%30*2;
			
			bw.write("#" + t + " " + h + " " + m + "\n");
		}
		bw.flush();
		br.close();
		bw.close();
	}
}
