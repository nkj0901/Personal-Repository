import java.util.Scanner;

public class Main11726타일링 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int[] memo = new int[N+1];
		memo[0] = 1;
		memo[1] = 1;
		
		for(int i = 2; i <= N; i++) {
			memo[i] = (memo[i-1]+memo[i-2])% 10007;
		}
		System.out.println(memo[N]);
	}
}
