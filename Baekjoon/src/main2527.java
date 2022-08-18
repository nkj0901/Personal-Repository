import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class main2527 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		for (int t = 0; t < 4; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int ax = Integer.parseInt(st.nextToken());
			int ay = Integer.parseInt(st.nextToken());
			int ap = Integer.parseInt(st.nextToken());
			int aq = Integer.parseInt(st.nextToken());
			int bx = Integer.parseInt(st.nextToken());
			int by = Integer.parseInt(st.nextToken());
			int bp = Integer.parseInt(st.nextToken());
			int bq = Integer.parseInt(st.nextToken());

			// 아무것도 만나지 않을 때
			if (ap < bx || bp < ax || bq < ay || by > aq) {
				System.out.println("d");
			}

			// 점이 만날 때
			else if (bx == ap && by == aq || ax == bp && ay == bq || ax == bp && aq == by || bx == ap && bq == ay) {
				System.out.println("c");
			}
			// 선이 만날 때, 만나지 않는 것은 이미 위에서 걸러졌음
			else if (aq == by || ap == bx || ay == bq || bp == ax) {
				System.out.println("b");
			} 
			//나머지는 겹치는 것
			else {
				System.out.println("a");
			}

		}
	}
}
