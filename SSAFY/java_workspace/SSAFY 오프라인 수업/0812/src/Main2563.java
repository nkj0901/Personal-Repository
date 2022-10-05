import java.util.Scanner;

public class Main2563 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		// 색종이를 붙일 도화지 만들기
		int[][] arr = new int[100][100];

		int cnt = 0;
		// 몇번 색종이를 붙일 것인지
		for (int t = 0; t < T; t++) {
			int x = sc.nextInt();
			int y = sc.nextInt();

			int xx = x + 10;
			int yy = y + 10;
			if (x < 91 && y < 91) {
				for (int i = x; i < xx; i++) {
					for (int j = y; j < yy; j++) {
						arr[i][j] = 1;
					}
				}
			}
		}
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if (arr[i][j] == 1) {
					cnt++;
				}
			}
		}
		System.out.println(cnt);
	}
}