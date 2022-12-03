import java.util.Scanner;

public class Solution3314보충학습과평균 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int t = 1; t <= T; t++) {
		
		int sum = 0;
		for (int i = 0; i <5; i++) {
			int score = sc.nextInt();
			if (score >= 40) {
				sum+=score;
			} else {
				sum+=40;
			}
		}
		System.out.println("#" + t + " " + sum/5);
		}
	}
}
