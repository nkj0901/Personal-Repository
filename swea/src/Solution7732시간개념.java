import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution7732시간개념 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {

			st = new StringTokenizer(br.readLine(), ":");
			int nowH = Integer.parseInt(st.nextToken());
			int nowM = Integer.parseInt(st.nextToken());
			int nowS = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine(), ":");
			int promiseH = Integer.parseInt(st.nextToken());
			int promiseM = Integer.parseInt(st.nextToken());
			int promiseS = Integer.parseInt(st.nextToken());
			
			if(promiseH == 0 && (promiseM < nowM || promiseS < nowS)) promiseH = 24;
			
			int ansS=0, ansM=0, ansH=0;
			ansS = promiseS - nowS;
			if (ansS < 0) {
				ansS = 60 + ansS;
				promiseM--;
			}
			ansM = promiseM - nowM;
			if (ansM < 0) {
				promiseH--;
				ansM = 60 + ansM;
			}
			ansH = promiseH - nowH;
			if (ansH < 0)
				ansH = 24 + ansH;
			
			

			System.out.printf("#%d %02d:%02d:%02d", t, ansH, ansM, ansS);
			System.out.println();
		}
	}
}
