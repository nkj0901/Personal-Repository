import java.util.Scanner;

public class Solution13218조별과제 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int i = 1; i <= T; i++) {
			int N = sc.nextInt();
			int ans = N/3;
			System.out.println("#" + i + " " + ans);
		}
	}
}
