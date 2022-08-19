package swea;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution1289 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			String s = br.readLine();
			char[] arr1 = s.toCharArray();

			char[] arr2 = new char[arr1.length];

			for (int i = 0; i < arr2.length; i++) {
				arr2[i] = '0';
			}
			// arr1과 arr2 비교
			int cnt = 0;
			for (int i = 0; i < arr2.length; i++) {
				// 두개가 같지 않으면 그 인덱스부터 나머지 인덱스를 다 a로 채움
				if (arr1[i] != arr2[i]) {
					char a = arr1[i];
					cnt++;
					for (int j = i; j < arr2.length; j++) {
						arr2[j] = a;
					}
				}
			}
			bw.write("#" + t + " " + cnt);
			bw.newLine();
		}
		bw.flush();
		br.close();
		bw.close();
	}
}
