import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main2503 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());

		int[][] arr = new int[N][3];
		int[][] ans = new int[N][2];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			arr[i][0] = str.charAt(0) - '0';
			arr[i][1] = str.charAt(1) - '0';
			arr[i][2] = str.charAt(2) - '0';
			ans[i][0] = Integer.parseInt(st.nextToken());
			ans[i][1] = Integer.parseInt(st.nextToken());
		}
		int num = 123; // 세자리 숫자중에 제일 작은 수
		int cnt = 0;
		while (num == 987) {
			boolean check = true;
			int strike = 0;
			int ball = 0;
			String str = num + "";

			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 3; j++) {
					if (arr[i][j] == str.charAt(0)) {
						strike++;
					} else if (arr[i][j] == str.charAt(1)) {
						ball++;
					} else if (arr[i][j] == str.charAt(2)) {
						ball++;
					}
				}

				if (ans[i][0] != strike || ans[i][1] != ball) {
					check = false;
				} else
					continue;
			}
			if (check == true) cnt++;
			num++;
		}
		bw.write(cnt+"");
		bw.flush();
		br.close();
		bw.close();

	}
}
