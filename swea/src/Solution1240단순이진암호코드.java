import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution1240단순이진암호코드 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		String[] code = { "0001101", "0011001", "0010011", "0111101", "0100011", "0110001", "0101111", "0111011",
				"0110111", "0001011" };

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {

			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int[] ansArr = new int[7];

			// 숫자 1이 포함된 줄이 나올 때까지 와일문을 돌린다.
			String str = "";
			for (int i = 0; i < N; i++) {
				str = br.readLine();
				if (str.contains("1"))
					break;
			}
			System.out.println(str.contains("1"));
			System.out.println(str);
			char[] arr = str.toCharArray();

			int cnt = 0; // 여태 나온 수의 숫자
			for (int i = str.length() - 1; i >= 0; i--) {
				String tmp = "";
				if (arr[i] == '1') {
						for (int j = i-6; j >= i; j++) {
							tmp += str.charAt(i - j);
							System.out.print(str);
						}
						for (int j = 0; j < 10; j++) {
							if (tmp.equals(code[j])) {
								ansArr[cnt++] = j;
						}
						i-=7;
					}
					System.out.println();
				}
			}
			System.out.println(Arrays.toString(ansArr));
		}
	}
}
