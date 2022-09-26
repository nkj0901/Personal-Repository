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
			int end = N-1;
			int num = 1;
			
			
			
			for (int i = 0; i < N-1; i++) {
				
				//위
				for (int j = i; j < N-i; j++) {
					arr[i][j] = num++;
				}
				
				//오른쪽
				for (int j = i+1; j < N-i; j++) {
					arr[j][end] = num++;
				}
				//아래쪽
				for (int j = i; j < N-i; j++) {
					arr[end][N-j-1] = num++;
				}
				
				//왼쪽
				for (int j = i+1; j < N-i-1; j++) {
					arr[j][start] = num++;
				}
				
				start++;
				end--;
			}
			
			for(int[] a : arr) {
			System.out.println(Arrays.toString(a));
			}
		}
	}
}
