import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main2851 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// 10개의 수를 받기
		int sum = 0;
		int min = 100;
		int ans = 0;
		for (int i = 0; i < 10; i++) {
			sum += Integer.parseInt(br.readLine());
			// 계속 min이 작아질테니 min과 비교해서 더 커지는 상황을 찾으면 된다.
			if (Math.abs(100 - sum) <= min) {
				min = Math.abs(100 - sum);
				ans = sum;
			}
		}
		bw.write(ans+"");
		bw.flush();
		bw.close();
		br.close();
	}
}
