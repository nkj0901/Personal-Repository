
import java.util.Scanner;

public class Solution평균중간값 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {

			int[] arr = new int[10];
			int N = arr.length;

			// 배열만들기
			for (int m = 0; m < 10; m++) {
				arr[m] = sc.nextInt();
			}

			// 배열정렬하기-카운팅정렬으로 볼 것.
			//1. 먼저 제일 큰 숫자 구하기
			int max = 0;
			for(int i = 0; i < N; i++) {
				if(max < arr[i]) {
					max = arr[i];		
					}
				}
			
			// 2. 숫자 카운팅하기. 그 숫자가 나올 때 카운팅 배열에 1더하기
			int[] count = new int[max+1];
			for (int i = 0; i < N; i++) {
				count[arr[i]]++;
			} 
			
			// 배열의 누적합 구하기
			for(int i = 1; i < max; i++) {
				count[i+1] = count[i+1] + count[i]; 
			}
			
			// 뒤에서 부터 돌면서 count-1에 해당하는 인덱스에 넣기
			int[] tmp = new int[N];
			for(int i = N-1 ; i >= 0; i--) {
				int a = --count[arr[i]];
				tmp[a] = arr[i]; 
			}
			// 가운데 값 더하기
			int sum = 0;
			for (int i = 1; i < tmp.length - 1; i++) {
				sum += tmp[i];
			}
			double n = (double) sum / (tmp.length-2);
			System.out.println("#" + tc + " " + Math.round(n));
		}
	}
}
