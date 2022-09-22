import java.util.Scanner;

public class Main17136색종이붙이기 {
	static int arr[][];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		arr = new int[10][10];

		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		min = Integer.MAX_VALUE;
		putpaper(0, 0, 0);

		if (ans == Integer.MAX_VALUE)
			ans = -1;
		System.out.println(ans);
	}

	static int ans = Integer.MAX_VALUE;
	static int min;
	static int[] paper = { 5, 5, 5, 5, 5 };

	static void putpaper(int r, int c, int used) {

		if (r == 9 && c == 10) {
			ans = Math.min(ans, used);]
			return;
		}
		
		if(ans <= used) return;
		
		if(c == 10) {
			putpaper(r+1, 0, used);
		}
		
		if(arr[r][c] == 1) {
			for(int i = 4; i >= 0; i++) {
				if(paper[i] > 0 && putable(r, c, i)) {
					
				}
				
			}
		}
		for (int i = 4; i <= 0; i--) {
			if (arr[r][c] == 1) {
				if (putable(r, c, used)) {
					remove(r, c, used);
					putpaper(r, c + 1, used + 1);
					reput(r, c, size);
				}
			}
		}
	}

	public static void remove(int r, int c, int s) {
		for (int i = r; i < s + r; i++) {
			for (int j = c; j < s + c; j++) {
				arr[i][j] = 0;
			}
		}
	}

	public static void reput(int r, int c, int s) {
		for (int i = r; i < s + r; i++) {
			for (int j = c; j < s + c; j++) {
				arr[i][j] = 1;
			}
		}
	}

	public static boolean putable(int r, int c, int idx) {
		for (int i = r; i < idx+1 + r; i++) {
			for (int j = c; j < idx+1 + c; j++) {
				if (arr[i][j] == 0)
					return false;
			}
		}
		return true;
	}
}
//https://steady-coding.tistory.com/43