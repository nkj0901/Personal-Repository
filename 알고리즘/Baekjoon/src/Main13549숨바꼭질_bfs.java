import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main13549숨바꼭질_bfs {
	
	static class Node{
		int now, time;
		Node(int now, int time){
			this.now = now;
			this.time = time;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		Queue<Node> queue = new LinkedList<>();
		queue.add(new Node(N, 0));
		boolean[] check = new boolean[100001];

		int ans = 0;
		
		while(!queue.isEmpty()) {
			Node n = queue.poll();
			
			if(n.now == K) {
				ans = n.time;
				break;
			}
			
			if(check[n.now]) continue;
			check[n.now] = true;
			
			
			if(n.now*2 <= 100000)queue.add(new Node(n.now*2, n.time));
			if(n.now-1 >= 0) queue.add(new Node(n.now-1, n.time+1));
			if(n.now+1 <= 100000) queue.add(new Node(n.now+1, n.time+1));
			
		}
		System.out.println(ans);
	}
}
