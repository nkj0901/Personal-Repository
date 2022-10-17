import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main1916최소비용구하기 {
	
	static class Node implements Comparable<Node>{
		int v,w;
		Node(int v, int w){
			this.v = v;
			this.w = w;
		}
		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.w, o.w);
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		//정점개수
		int N = Integer.parseInt(br.readLine());
		//간선개수
		int bus = Integer.parseInt(br.readLine());
		List<Node>[] list = new ArrayList[N+1];
		
		for(int i = 0; i <= N; i++) {
			list[i] = new ArrayList<>();
		}
		
		//간선 입력받기
		for(int i = 0; i < bus; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			list[s].add(new Node(e, w));
		}
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		boolean[] visited = new boolean[N+1];
		int[] dist = new int[N+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		pq.add(new Node(start, 0));
		dist[start] = 0;
		
		while(!pq.isEmpty()) {
			Node curr = pq.poll();
			
			if(visited[curr.v]) continue;
			
			visited[curr.v] = true;
			
			for(Node node:list[curr.v]) {
				if(dist[node.v] > dist[curr.v]+node.w) {
					dist[node.v] = dist[curr.v]+node.w;
					pq.add(new Node(node.v, dist[node.v]));
				}
			}
		}
		System.out.println(dist[end]);
	}
}
