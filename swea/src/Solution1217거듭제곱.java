import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution1217거듭제곱 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		for (int t = 1; t <= 10; t++) {
			int testcase = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			bw.write("#" + t + " " + (int)Math.pow(N, M)+"\n");
		}
		bw.flush();
		br.close();
		bw.close();
	}
}
