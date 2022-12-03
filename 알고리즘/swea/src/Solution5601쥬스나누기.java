import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution5601쥬스나누기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			bw.write("#" + t + " ");

			int N = Integer.parseInt(br.readLine());

			for (int i = 0; i < N; i++) {
				bw.write("1/" + N + " ");
			}
			bw.newLine();
		}
		bw.flush();
		br.close();
		bw.close();
	}
}
