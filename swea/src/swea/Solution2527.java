package swea;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution2527 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());

		int mw = 0;
		int mh = 0;
		int sw = Integer.MAX_VALUE;
		int sh = Integer.MAX_VALUE;

		for (int i = 0; i < 6; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int direction = Integer.parseInt(st.nextToken());
			int size = Integer.parseInt(st.nextToken());

			// 4와 3의 길이 차이
			if (direction == 3 || direction == 4) {
				if (mw < size) {
					mw = size;
				} 
				if (sw > size) {
					sw = size;
				}
			}
			// 2와 1의 길의 차이
			if (direction == 1 || direction == 2) {
				if (mh < size) {
					mh = size;
				} 
				if (sh > size) {
					sh = size;
				}
			}
		}
		// 작은 삼각형 넓이
		int smallsquare = sw*sh;
		// 큰 삼각형 넓이
		int bigsquare = mw*mh;

		// 참외밭 넓이
		int field = bigsquare - smallsquare;

		bw.write(field * N);
		bw.flush();
		bw.close();
		br.close();
	}
}
