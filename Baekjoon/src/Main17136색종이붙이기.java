import java.util.Scanner;

public class Main17136색종이붙이기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		arr = new int[10][10];

		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		putpaper(0, 0, 0);

		if (ans == Integer.MAX_VALUE) {
			ans = -1;
		}

		System.out.println(ans);
	}

	static int arr[][];
	static int ans = Integer.MAX_VALUE;
	static int[] paper = { 0, 5, 5, 5, 5, 5 };

	static void putpaper(int r, int c, int used) {

		if (r >= 9 && c > 9) {
			ans = Math.min(ans, used);
			return;
		}

		if (ans <= used)
			return;

		if (c > 9) {
			putpaper(r + 1, 0, used);
			return;
		}

		if (arr[r][c] == 1) {
			for (int i = 5; i > 0; i--) {
				if (paper[i] > 0 && putable(r, c, i)) {
					attach(r, c, i);
					paper[i]--;
					putpaper(r, c + 1, used + 1);
					detach(r, c, i);
					paper[i]++;
				}
			}
		} else {
			putpaper(r, c + 1, used);
		}
	}

	public static void attach(int r, int c, int s) {
		for (int i = r; i < s + r; i++) {
			for (int j = c; j < s + c; j++) {
				arr[i][j] = 0;
			}
		}
	}

	public static void detach(int r, int c, int s) {
		for (int i = r; i < s + r; i++) {
			for (int j = c; j < s + c; j++) {
				arr[i][j] = 1;
			}
		}
	}

	public static boolean putable(int r, int c, int idx) {
		for (int i = r; i < idx + r; i++) {
			for (int j = c; j < idx + c; j++) {
				if (i < 0 || i >= 10 || j < 0 || j >= 10) {
					return false;
				}
				
				if (arr[i][j] == 0) {
					return false;
				}
			}
		}
		return true;
	}
}
//https://steady-coding.tistory.com/43