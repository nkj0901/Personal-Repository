import java.util.Scanner;

public class Solution1247최적경로 {
	static pos[] arr;
	static boolean[] visited;
	static int N;
	static int ans;
	static pos home;
	
	static class pos {
		int x;
		int y;
		
		pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args)  {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();
			
			arr = new pos[N];
			visited = new boolean[N];
			
			//집
			home = new pos(sc.nextInt(),sc.nextInt());
			//회사
			pos comp = new pos(sc.nextInt(),sc.nextInt());
			//고객집
			for (int i = 0; i < N; i++) {
				arr[i] = new pos(sc.nextInt(),sc.nextInt());
			}
			
			ans = Integer.MAX_VALUE;
			permutation(0, 0, comp);
			System.out.println("#" + t + " " + ans);
		}
	}

	public static void permutation(int idx, int dist, pos curr) {
		if (ans < dist) return;
		
		if (idx == N) {
			ans = Math.min(ans, dist+Math.abs(home.x-curr.x)+Math.abs(home.y-curr.y)); 
			return;
		}

		for (int i = 0; i < N; i++) {
			if (visited[i]) continue;
			visited[i] = true;
			permutation(idx + 1, dist+ Math.abs(arr[i].x-curr.x)+
					Math.abs(arr[i].y-curr.y), arr[i]);
			visited[i] = false;
		}
	}
}
