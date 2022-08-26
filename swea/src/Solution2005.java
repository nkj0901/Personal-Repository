import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution2005 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			bw.append("#" + tc);
			bw.newLine();

			int N = Integer.parseInt(br.readLine());

			int[][] arr = new int[N][N];

			for (int i = 0; i < N; i++) {
				for (int j = 0; j <= i; j++) {

					if (i >= 2 && j != 0 && j != i) {
						arr[i][j] = arr[i - 1][j] + arr[i - 1][j - 1];
						bw.append(arr[i][j] + " ");
					} else {
						arr[i][j] = 1;
						bw.append(arr[i][j] + " ");
					}
				}
				bw.newLine();
			}
		}
		bw.flush();
		br.close();
		bw.close();
	}
}
