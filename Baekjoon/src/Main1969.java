import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main1969 {
	static char maxChar = '0'; //가장 많이 나온 문자
	static int maxCharInt = 0; //가장 많이 나온 문자 수
	static int cnt = 0;
	static int A = 0;
	static int T = 0;
	static int G = 0;
	static int C = 0;
	static boolean tf = false;
	
	public static void func(char c) {
		if (c == 'A') {
			A++;
			if (maxCharInt < A) {
				maxCharInt = A;
				maxChar = 'A';
			} else if (maxCharInt == A) {
				if (maxChar > 'A') {
					maxChar = 'A';
				} 
			}
		} else if (c == 'T') {
			T++;
			if (maxCharInt < T) {
				maxCharInt = T;
				maxChar = 'T';
			} else if (maxCharInt == T) {
				if (maxChar > 'T') {
					maxChar = 'T';
				} 
			}
		} else if (c == 'G') {
			G++;
			if (maxCharInt < G) {
				maxCharInt = G;
				maxChar = 'G';
			} else if (maxCharInt == G) {
				if (maxChar > 'G') {
					maxChar = 'G';
				} 
			}
		} else if (c == 'C') {
			C++;
			if (maxCharInt < C) {
				maxCharInt = C;
				maxChar = 'C';
			} else if (maxCharInt == C) {
				if (maxChar > 'C') {
					maxChar = 'C';
				} 
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st;
		st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		char[][] arr = new char[N][M];

		// 배열채우기
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				arr[i][j] = str.charAt(j);
			}
		}
		
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				func(arr[j][i]);
			}
			bw.write(maxChar+"");
			cnt+=N-maxCharInt;
			A = 0; //각 숫자 초기화
			T = 0;
			G = 0;
			C = 0;
			maxChar = '0';
			maxCharInt = 0;
		}
		bw.write("\n"+cnt+"");
		bw.flush();
		br.close();
		bw.close();
	}
}
