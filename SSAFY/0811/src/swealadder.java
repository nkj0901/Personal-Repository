import java.util.Scanner;

public class swealadder {
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

			// 우리가 보아야 하는 위치
			int[] dr = { 0, +1, 0, 1 };
			int[] dc = { 1, 1, -1, -1 };

			int i = 1;
			int j = 1;
			int jj = 0;

			// 맨 윗줄만 반복문 돌려서 탐색
			for (j = 1; j < 101; j++) {
				// 만약 arr[i][j] == 1일 때 시행
				i = 1;
				jj = j;

				while (jj == 101) {

					while (arr[i][jj] == 1 || arr[i][jj] == 2) {
						if (arr[i][jj] == 2) {
							System.out.println(j);
							break;
						}
						i++;
					}

					// 1이 오른쪽에 있으면 1아닐 때까지 j++
					if (arr[i - 1][jj + 1] == 1) {
						while (arr[i][jj] == 1) {
							++jj;
						}
					} else if (arr[i - 1][jj - 1] == 1) {
						while (arr[i][jj] == 1) {
							--jj;
						}
						// 만약 왼쪽에 있다면 왼쪽에 1이 아닐 때까지 j-1
					}
					
					
				}
			}
		}
	}
}
