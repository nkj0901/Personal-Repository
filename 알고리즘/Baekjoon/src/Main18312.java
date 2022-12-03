import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main18312 {
	static int K;
	static int cnt;
	static boolean tf = false;

	// 해당 숫자가 있는지 판별해주는 함수
	public static void func(int num) {
		if (num < 10 && K == 0) {
			tf = true;
		} else {
			String str = Integer.toString(num);
			for (int i = 0; i < str.length(); i++) {
				if (str.charAt(i) == K + '0') {
					tf = true;
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		// 한자리 일 때 0 생각할 것
		for (int hour = 0; hour <= N; hour++) {
			for (int minute = 0; minute < 60; minute++) {
				for (int second = 0; second < 60; second++) {
					tf = false;
					func(second);
					func(minute);
					func(hour);
					if (tf == true) cnt++;
				}
			}
		}
		bw.write(cnt + "");
		bw.flush();
		br.close();
		bw.close();
	}
}
