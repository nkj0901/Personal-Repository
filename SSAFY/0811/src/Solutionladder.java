import java.util.Scanner;

public class Solutionladder {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 테스트케이스 돌리기
		for (int t = 0; t < 10; t++) {
			// 배열만들기
			int[][] arr = new int[102][102];
			for (int a = 1; a < 101; a++) {
				for (int b = 1; b < 101; b++) {
					arr[a][b] = sc.nextInt();
				}
			}
			int i;
			int a = 0; // 몇번 인덱스에 있는지 기억
			int j = 101;
			for (i = 102; j < 102; i++) {
				if (arr[i][j] == 2) {
					a = i;
				}
			}
			while (a > 0) {
				while (arr[a - 1][j] == 1) {
					a--;
				}

				if (arr[a][j + 1] == 1) {
					while (arr[a][j + 1] == 1) {
						j++;
					}
				} else if (arr[a][j - 1] == 1) {
					while (arr[a][j - 1] == 1)
						j--;
				}
			}

			System.out.println("i);
		}
	}
}