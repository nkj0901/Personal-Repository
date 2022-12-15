import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main1449수리공항승_그리디 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());

		int[] pipe = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			pipe[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(pipe);

		int ans = 1;
		int curTape = L - 1;
		int beforeLocation = pipe[0];
		for (int i = 1; i < N; i++) {
			// 현재 붙어있는 테이프가 다음 새는 위치까지 붙일 수 있는 지 확인
			// 붙일 수 있다면 붙여
			if (pipe[i] - beforeLocation <= curTape) {
				curTape -= pipe[i] - beforeLocation;
				beforeLocation = pipe[i];
			} // 붙일 수 없다면 새테이프로 붙여
			else {
				ans++;
				curTape = L-1;
				beforeLocation = pipe[i];
			}
		}
		System.out.println(ans);
	}
}
