import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main1697숨바꼭질 {
	
	static class Node {
		int n, cnt;
		Node(int n, int cnt){
			this.n = n;
			this.cnt = cnt;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		queue = new LinkedList<>();
		check = new boolean[100001];
		ans = 0;
		bfs(N, 0);
		
		System.out.println(ans);
	}

	static int M, N, ans;
	static Queue<Node> queue;
	static boolean[] check;

	private static void bfs(int n, int cnt) {
		queue.add(new Node(n, cnt));
		
		while(!queue.isEmpty()) {
			Node N = queue.poll();
			int nn = N.n;
			int nc = N.cnt;
			
			if(N.n == M) {
				ans = N.cnt;
				return;
			}
			
			if(nn+1 < 100001 && !check[nn+1]) {
				queue.add(new Node(nn+1, nc+1));
				check[nn+1] =true;
			}
			if(nn*2 < 100001 && !check[nn*2]) {
				queue.add(new Node(nn*2, nc+1));
				check[nn*2] =true;
			}
			if(nn-1 >= 0 && !check[nn-1]) {
				queue.add(new Node(nn-1, nc+1));
				check[nn-1] =true;
			}
		}
	}
}
