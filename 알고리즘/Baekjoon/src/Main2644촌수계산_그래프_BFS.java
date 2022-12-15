import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main2644촌수계산_그래프_BFS {
	
	static class Node{
		int num, cnt;
		
		Node(int num, int cnt){
			this.num = num;
			this.cnt = cnt;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		int m = Integer.parseInt(br.readLine());
		
		list = new ArrayList[n+1];
		
		for(int i = 0; i < n+1; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			list[s].add(e);
			list[e].add(s);
		}
		
		System.out.println(bfs(start, end));
	}
	static List<Integer>[] list;
	static int n;

	private static int bfs(int start, int end) {
		boolean[] visited = new boolean[n+1];
		Queue<Node> queue = new LinkedList<>();
		queue.add(new Node(start, 0));
		
		while(!queue.isEmpty()) {
			Node n = queue.poll();
			
			if(visited[n.num]) continue;
			visited[n.num] = true;
			
			if( n.num == end) { 
				return n.cnt;
			}
			
			for(int i = 0; i < list[n.num].size(); i++) {
				queue.add(new Node(list[n.num].get(i), n.cnt+1));
			}
		}
		return -1;
	}
}
