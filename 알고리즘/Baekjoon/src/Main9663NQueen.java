import java.util.Scanner;

public class Main9663NQueen {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		visited = new boolean[N][N];
		
		ans = 0;
		System.out.println(putQueen(0));
	}
	static int N;
	static boolean[][] visited;
	static int ans;
	
	static int putQueen(int idx) {
		if (idx == N) {
			return ans++;
		}
		for (int i = 0; i < N; i++) {
			if (putable(idx, i)) {
				visited[idx][i] = true;
				putQueen(idx+1);
				visited[idx][i] = false;
			}
		}
		return ans;
	}
	
	static boolean putable(int r, int c) {
		for (int i = r-1, j = 1; i >= 0; i--, j++) {
				//위쪽 검사
				if(visited[i][c]) return false;
				//왼쪽대각선
				if(c-j >= 0 && visited[i][c-j]) return false;
				//오른쪽대각선
				if(c+j < N && visited[i][c+j]) return false;
		}
		return true;
	}
}
