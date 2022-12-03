import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution3431준환이운동관리 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			bw.write("#" + t + " ");
			st = new StringTokenizer(br.readLine());
			
			int L = Integer.parseInt(st.nextToken());
			int U = Integer.parseInt(st.nextToken());
			int X = Integer.parseInt(st.nextToken());
			
			if (X > U) bw.write("-1");
			else if (X <= U && X >= L) bw.write("0");
			else if (X < L) bw.write((L-X)+"");
			
			bw.newLine();
		}
		bw.flush();
		br.close();
		bw.close();
	}
}
