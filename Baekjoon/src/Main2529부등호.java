import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main2529부등호 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		//부등호의 수
		k = Integer.parseInt(br.readLine());
		
		//고른 숫자 저장할 배열
		sel = new int[k + 1];
		//부등호 저장할 배열
		sign = new String[k];

		//배열채우기
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < k; i++) {
			sign[i] = st.nextToken();
		}

		min = Long.MAX_VALUE;
		max = Long.MIN_VALUE;
		//방문체크
		check = new boolean[10];
		permutation(0);
		
		smax = smax==null? smin:smax;
		smin = smin==null? smax:smin;
		System.out.printf(smax + " " + smin);

	}

	static int[] sel;
	static boolean[] check;
	static String[] sign;
	static int k;
	static long max, min;
	static String smax, smin;

	private static void permutation(int n) {
		
		if (n == k + 1) {
			
			for (int i = 0; i < k; i++) {
				if (sign[i].equals(">")){
					if(sel[i] < sel[i+1]) {
						return;
					}
				}
				if (sign[i].equals("<")) {
					if(sel[i] > sel[i+1]) {
						return;
					}
				}
			}

			// 각 자리 수를 하나의 숫자로 합치기
			long tmpAns = 0;
			for (int i = 0; i < k+1; i++) {
				tmpAns += sel[i] * Math.pow(10, k-i);

			}
			
			if (min > tmpAns) {
//				System.out.println(tmpAns);
				min = tmpAns;
				smin = "";
				for(int i = 0; i < k+1; i++) {
					smin+=String.valueOf(sel[i]);
				}
			}
			if (max < tmpAns) {
//				System.out.println(tmpAns);
				max = tmpAns;
				smax = "";
				for(int i = 0; i < k+1; i++) {
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
