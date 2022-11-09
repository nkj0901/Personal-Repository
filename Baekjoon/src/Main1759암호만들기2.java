import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main1759암호만들기2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		arr = new char[C];
		check = new boolean[C];

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < C; i++) {
			arr[i] = st.nextToken().charAt(0);
		}
		Arrays.sort(arr);

		dfs(0, 0);

		bw.flush();
		bw.close();
		br.close();

	}

	static BufferedWriter bw;
	static int L, C;
	static boolean[] check;
	static char[] arr;

	private static void dfs(int idx, int sidx) throws IOException {
		if (sidx == L) {
			StringBuilder sb = new StringBuilder();
			int m = 0;
			int j = 0;
			
			for (int i = 0; i < C; i++) {
				if (check[i]) {
					if (isVowel(arr[i])) {
						m++;
					} else {
						j++;
					}
					sb.append(arr[i]);
				}
			}

			if (m >= 1 && j >= 2) {
				System.out.println(sb);
			}

		} else {
			// 시작을 idx부터 해줘야 현재 마지막으로 선택한 애보다 작은 애를 가져오지 않는다.
			for (int i = idx; i < C; i++) {
				check[i] = true; 
				dfs(i + 1, sidx + 1);
				check[i] = false;
			}
		}
	}

	public static boolean isVowel(char c) {
		if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
			return true;
		} else {
			return false;
		}
	}

}