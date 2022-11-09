import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2529부등호 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		k = Integer.parseInt(br.readLine());

		sel = new int[k + 1];
		sign = new String[k];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < k; i++) {
			sign[i] = st.nextToken();
		}

		min = Integer.MAX_VALUE;
		max = Integer.MIN_VALUE;
		check = new boolean[10];
		permutation(0);

		System.out.printf(smax + " " + smin);

	}

	static int[] sel;
	static int[] num = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
	static boolean[] check;
	static String[] sign;
	static int k, max, min;
	static String smax, smin;

	private static void permutation(int n) {

		if (n == k + 1) {

			for (int i = 0; i < k; i++) {
				if (sign[i].equals(">") && sel[i] < sel[i + 1])
					return;
				else if (sign[i].equals("<") && sel[i] > sel[i + 1])
					return;
			}

			// 각 자리 수를 하나의 숫자로 합치기
			int tmpAns = 0;
			for (int i = k; i >= 0; i--) {
				tmpAns += sel[i] * Math.pow(10, i);

			}
			if (min > tmpAns) {
				min = tmpAns;
				smin = "";
				for(int i = k; i >= 0; i--) {
					smin+=String.valueOf(sel[i]);
				}
			}
			if (max < tmpAns) {
				max = tmpAns;
				smax = "";
				for(int i = k; i >= 0; i--) {
					smax+=String.valueOf(sel[i]);
				}
			}
			return;
		}

		for (int i = 0; i < 10; i++) {

			if (check[i])
				continue;
			check[i] = true;
			sel[n] = i;
			permutation(n + 1);
			check[i] = false;
		}
	}

}
