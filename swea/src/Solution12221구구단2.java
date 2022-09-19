import java.util.Scanner;

public class Solution12221구구단2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			System.out.print("#"+ t + " ");
			if(a < 10 && b < 10) {
				System.out.println(a*b);
			} else {
				System.out.println(-1);
			}
		}
	}
}
