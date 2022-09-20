import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution6913동철이의프로그래밍대회 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int max = 0; //일등 몇개맞았어?
			int p = 0; //일등한 사람 수
			for (int i = 0; i < M; i++) {
				int cnt = 0;
				st = new StringTokenizer(br.readLine());
				int num = Integer.parseInt(st.nextToken());
				if (num == 1) {
					for (int j = 0; j < N; j++) {
						if (Integer.parseInt(st.nextToken()) == 1) {
							cnt++;
						}
					} 
					if (cnt > max) {
						max = cnt;
						p++;
					} else if (cnt == max) {
						p++;
					}
				}
			}
			bw.write("#" + t + " " + p + " " + max);
		}
		bw.flush();
		br.close();
		bw.close();
	}
}
