import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution6730장애물경주난이도 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			int before = Integer.parseInt(st.nextToken());
			int now = 0;
			int incline = 0;
			int decline = 0;

			for (int i = 1; i < N; i++) {
				now = Integer.parseInt(st.nextToken());
				if (before - now < 0) {
					if (-(before - now) > incline) {
						incline = -(before - now);
					}
				} else if (before - now > 0) {
					if (before - now > decline) {
						decline = before - now;
					}
				}
				before = now;
			}
			bw.write("#" + t + " " + incline + " " + decline + "\n");
		}
		bw.flush();
		br.close();
		bw.close();
	}
}
