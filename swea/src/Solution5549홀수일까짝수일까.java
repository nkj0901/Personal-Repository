import java.util.Scanner;

public class Solution5549홀수일까짝수일까 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int t = 1; t <= T; t++) {
			
			String str = sc.next();
			int tmp = str.charAt(str.length()-1)-'0';
			
			System.out.print("#" + t + " ");
			if(tmp%2==0) System.out.println("Even");
			else System.out.println("Odd");
		}
	}
}
