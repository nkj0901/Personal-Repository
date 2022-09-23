import java.util.Scanner;

public class Solution4751다솔이의다이아몬드장식 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		int[] dx = { -2, -1, 0, 1, 2, 1, 0, -1 };
		int[] dy = { 0, 1, 2, 1, 0, -1, -2, -1 };

		for (int t = 1; t <= T; t++) {
			String str = sc.next();
			int N = str.length();
			int l = N*4+1;//배열의 길이
			
			char[][] arr = new char[5][l];
			
			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < l; j++) {
					arr[i][j] = '.';
				}
			}
			
			//첫글자는 무조건 arr[2][2]에 오게 되어 있음
			//이걸 조정해주면서 글자를 출력할 예정
			int x = 2;
			int y = 2;

			for (int i = 0; i < N; i++) {
				if (i == 0) {
					arr[x][y] = str.charAt(i);
				} else {
					arr[x][y+=4] = str.charAt(i);
				}
				
				for (int j = 0; j < 8; j++) {
					arr[x+dx[j]][y+dy[j]] = '#';
				}
			}
			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < l; j++) {
					System.out.print(arr[i][j]);
				}
				System.out.println();
			}
		}
	}
}
