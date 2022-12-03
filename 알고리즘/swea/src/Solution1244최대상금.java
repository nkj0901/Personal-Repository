import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Solution1244최대상금 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			String str = sc.next();
			N = sc.nextInt();
			c = new int[str.length()];
			for(int i = 0 ; i < str.length(); i++) {
				c[i] = str.charAt(i)-'0';
			}
			ans =0;
			max = 0;
//			System.out.println(Arrays.toString(c));
			dfs(0,0);
			
			System.out.println("#" + t + " " + max);
		}

				
	}
	
	static int[] c;
	static int N, max, ans;
	// 지금까지 스왑한 횟수와 바꿀 인덱스 자리
	private static void dfs(int cnt, int idx) {
		
		if (cnt >= N) {
			ans = 0;
//			System.out.println(Arrays.toString(c));
			for(int n : c) {
				ans=(ans*10)+n;
			}
			max = Math.max(ans, max);
			return;
		}
		
		for(int i = idx; i < c.length-1; i++) {
			for(int j = i+1; j < c.length; j++) {
				
				swap(i, j);
				dfs(cnt+1, i);
				swap(i, j);//원래대로 돌리기
			}
		}
	}
	private static void swap(int i, int j) {
		int tmp = c[i];
		c[i] = c[j];
		c[j] = tmp;
	}
}
