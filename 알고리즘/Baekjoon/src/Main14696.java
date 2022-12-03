import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main14696 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// 라운드 횟수 입력받기
		int T = Integer.parseInt(br.readLine());

		// 라운드 수 만큼 A와 B의 입력값을 받기
		for (int t = 0; t < T; t++) {

			// A의 입렵값을 받기
			StringTokenizer st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int[] Aarr = new int[5];
			for (int i = 0; i < A; i++) {
				Aarr[Integer.parseInt(st.nextToken())]++;
			}

			// B의 입력값을 받기
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			int B = Integer.parseInt(st2.nextToken());
			int[] Barr = new int[5];
			for (int i = 0; i < B; i++) {
				Barr[Integer.parseInt(st2.nextToken())]++;
			}
			// 각각 인덱스에 해당하는 값 비교해보기
			if (Aarr[4] != Barr[4]) {
				if (Aarr[4] > Barr[4])
					bw.write("A");
				else
					bw.write("B");
			} else if (Aarr[3] != Barr[3]) {
				if (Aarr[3] > Barr[3])
					bw.write("A");
				else
					bw.write("B");
			} else if (Aarr[2] != Barr[2]) {
				if (Aarr[2] > Barr[2])
					bw.write("A");
				else
					bw.write("B");
			} else if (Aarr[1] != Barr[1]) {
				if (Aarr[1] > Barr[1])
					bw.write("A");
				else
					bw.write("B");
			} else {
				bw.write("D");
			}
			bw.newLine();
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
