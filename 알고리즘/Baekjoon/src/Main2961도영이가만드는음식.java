import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main2961도영이가만드는음식 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());

		int[] sour = new int[N];
		int[] bitt = new int[N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			sour[i] = Integer.parseInt(st.nextToken());
			bitt[i] = Integer.parseInt(st.nextToken());
		}
		
		int min = Integer.MAX_VALUE;
		for (int i = 1; i < (1 << N); i++) {
			int sourSum = 1;
			int bittSum = 0;
			for (int j = 0; j < N; j++) {
				if ((i & (1 << j)) > 0) {
					sourSum*=sour[j];
					bittSum+=bitt[j];
				}
			}
			if (Math.abs(sourSum-bittSum) < min) {
				min = Math.abs(sourSum-bittSum);
			}
		}
		bw.write(min+"");
		bw.flush();
		br.close();
		bw.close();
	}
}
