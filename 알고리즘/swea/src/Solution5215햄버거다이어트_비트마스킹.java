import java.util.Scanner;

public class Solution5215햄버거다이어트_비트마스킹 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int t = 1; t <= T; t++) {
			
			int N = sc.nextInt();
			int L = sc.nextInt();
			//N개 만큼의 배열 두개를 만들어(맛과 칼로리)
			int[] score = new int[N];
			int[] kcal = new int[N];
			
			//배열채우기
			for (int i = 0; i < N; i++) {
				score[i] = sc.nextInt();
				kcal[i] = sc.nextInt();
			}
			
			//모든 경우의 수 보기
			int max = 0;
			for(int i = 1; i < (1<<N); i++) {
				//재료 하나씩 들어있는지 볼거야
				int scoreSum = 0;
				int kcalSum = 0;
				for (int j = 0; j < N; j++) {
					if ((i & (1<<j)) > 0) {
						scoreSum+=score[j];
						kcalSum+=kcal[j];
					}
				}
				if(kcalSum <= L && max < scoreSum) {
					max = scoreSum;
				}
			}
			
			System.out.println("#" + t + " " + max);
		}
	}
}
