package swea;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution5215 {
	static int[] score;
	static int[] kcal;
	static int L, N, max;

	static void func(int n, int ssum, int ksum) {
		if (ksum > L) {
			return;
		}
		if (n == N) {
			if (ssum > max) {
				max = ssum;
			}
			return;
		}
		func(n + 1, ssum + score[n], ksum + kcal[n]);
		func(n + 1, ssum, ksum);
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		// 테스트케이스 받기
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			bw.append("#" + tc + " ");
			max = 0;
			// 재료 수와 제한 칼로리 받기
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			score = new int[N];
			L = Integer.parseInt(st.nextToken());
			kcal = new int[N];

			// 재료 맛 점수와 칼로리 배열 만들기
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				score[i] = Integer.parseInt(st.nextToken());
				kcal[i] = Integer.parseInt(st.nextToken());
			}
			func(0, 0, 0);
			bw.append(max + "");
			bw.newLine();
		}
		bw.flush();
		br.close();
		bw.close();
	}
}
