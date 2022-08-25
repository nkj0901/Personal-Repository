import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//재귀함수를 이용해서 풀어보기
public class Solution2817 {
	static int K, cnt;
	static int[] arr;
	static BufferedWriter bw;

	// 재귀함수 만들기
	static void func(int n, int sum) throws IOException {
		if (n == arr.length) {
			if (sum == K)
				cnt++;
			return;
		}
		// 선택한 것, 선택 안한 것
		func(n + 1, sum + arr[n]);
		func(n + 1, sum);
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			cnt =0; //static으로 쓸 때 초기화 신경써줄 것

			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			arr = new int[N];
			K = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());
			for (int n = 0; n < N; n++) {
				arr[n] = Integer.parseInt(st.nextToken());
			}

			bw.append("#" + tc + " ");
			func(0, 0);
			bw.append(cnt + "");
			bw.newLine();
		}
		bw.flush();
		br.close();
		bw.close();

	}
}
