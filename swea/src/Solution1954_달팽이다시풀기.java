import java.util.Arrays;
import java.util.Scanner;

public class Solution1954_달팽이다시풀기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {

			int N = sc.nextInt();

			int[][] arr = new int[N][N];

			int start = 0;
			int end = N - 1;
			int num = 1;

			while (true) {
				if (num > N * N)
					break;

				// 위
				for (int j = start; j <= end; j++) {
					arr[start][j] = num++;
				}

				// 오른쪽
				for (int j = start + 1; j <= end; j++) {
					arr[j][end] = num++;
				}
				// 아래쪽
				for (int j = end - 1; j >= start; j--) {
					arr[end][j] = num++;
				}
				end--;

				// 왼쪽
				for (int j = end; j > start; j--) {
					arr[j][start] = num++;
				}
				start++;
			}
			System.out.println("#" + t + " ");
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					System.out.print(arr[i][j]+" ");
				}
				System.out.println();
			}
		}
	}
}
