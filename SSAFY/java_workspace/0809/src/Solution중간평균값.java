import java.util.Scanner;

public class Solution중간평균값 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			
			int[] arr = new int[10];
			
			// 배열만들기
			for(int m =0; m < 10; m++) {
				arr[m] = sc.nextInt();
			}
			
			//배열정렬하기
			for (int i = 0; i < arr.length - 1; i++) {
				for (int j = 0; j < arr.length - 1 - i; j++) {
					if (arr[j] > arr[j + 1]) {
						int tmp = arr[j];
						arr[j] = arr[j + 1];
						arr[j + 1] = tmp;
					}
				}
			} // 정렬 끝
			int sum = 0;
			for (int a = 1; a < arr.length - 1; a++) {
				sum += arr[a];
			}
			double n = (double)sum/(arr.length-2);
			System.out.println("#" + tc + " " + Math.round(n));
		}
	}
}
