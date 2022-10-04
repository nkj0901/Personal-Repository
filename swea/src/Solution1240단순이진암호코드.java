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
			int N = Integer.parseInt(st.nextToken()); //행
			int M = Integer.parseInt(st.nextToken()); //열
			int[] ansArr = new int[8]; //나온 암호 저장

			// 숫자 1이 포함된 줄이 나올 때까지 와일문을 돌린다.
			String str = ""; // 일단 문자열받고
			String tmp = ""; // 1있으면 여기 저장
			for (int i = 0; i < N; i++) {
				tmp = br.readLine();
				if (tmp.contains("1"))
					str = tmp;
			}

			// 뒤에서 부터 보면서 1일 나오는지 보기
			int idx = 7;
			for (int i = str.length() - 1; i >= 0; i--) {

				if (str.charAt(i) == '1') {
					// 1을 발견한 곳부터 암호 8개 연속으로 뽑아야 하니까
					for (int s = 0; s < 8; s++) {
						String tmp1 = "";
						for (int j = i - 6; j <= i; j++) {
							tmp1 += str.charAt(j);
						}
						for (int j = 0; j < 10; j++) {
							if (tmp1.equals(code[j])) {
								ansArr[idx--] = j;
							}
						}
						i -= 7;
					}
				}
			}
			int ans = 0;
			int ans1 = 0; // 일단, 짝수 홀수 합을 구해
			int ans2 = 0;
			for (int i = 0; i < 8; i++) {
				if (i % 2 == 0) { // 배열이 0부터 시작이니까 짝수인덱스가 홀수번째 수야..
					ans1 += ansArr[i];
				} else {
					ans2 += ansArr[i];
				}
			}
			
			//홀수자리합*3+짝수자리합이 10으로 나눠지면 자리수 다 더해서 답출력 아니면 0출력
			if ((ans1 * 3 + ans2) % 10 == 0) {
				for (int i = 0; i < 8; i++) {
					ans += ansArr[i];
				}
			} else {
				ans = 0;
			}
			System.out.println("#" + t + " " + ans);
		}
	}
}
