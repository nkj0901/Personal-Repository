import java.util.Arrays;
import java.util.Scanner;

public class Main1182부분수열의합 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		S = sc.nextInt();
		
		arr = new int[N];
		sel = new boolean[N];
		
		for(int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		
		cnt = 0;
		combi(0, 0);
		
		if(S == 0) {
			cnt--;
		}
		
		System.out.println(cnt);
	}
	static int N, S, cnt;
	static int[] arr;
	static boolean[] sel;
	
	private static void combi(int idx, int sum) {
		
		if(idx == N) {
			if(sum == S) cnt++;
			return;
		}
		
		//선택함
		sel[idx] = true;
		combi(idx+1, sum + arr[idx]);
		sel[idx] = false;
		//선택안함
		combi(idx+1, sum);
	}
}
