import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main1238파티_다잌스트라 {
	
	static class Node implements Comparable<Node>{
		int s, e, w;
		Node(int s, int e, int w){
			this.s = s;
			this.e = e;
			this.w = w;
		}
		@Override
		public int compareTo(Node o) {
			return this.w - o.w;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); //도시, 학생수
		int M = Integer.parseInt(st.nextToken()); //도로 개수
		int X = Integer.parseInt(st.nextToken()); //시작점
		
		List<Node>[] list = new ArrayList[N+1];
		
		//인접리스트 만들기
		for(int i = 0; i < N+1; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			list[s].add(new Node(s, e, w));
		}
		
		int[] dist = new int[N+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		boolean[] visited = new boolean[N+1];
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.addAll(list[X]);
		//시작점 방문 처리
		visited[X]=true;
		dist[X] = 0;
		
		while(!pq.isEmpty()) {
			//젤 짧은 애가 튀어나옴
			Node n = pq.poll();
			
			if(visited[n.e]) continue;
			visited[n.e] = true;
			System.out.println(dist[n.e]);
			if(dist[n.s]+n.w < dist[n.e]) {
				dist[n.e] = dist[n.s]+n.w;
				System.out.println(dist[n.e]);
			}
			pq.addAll(list[n.e]);
		}
		int max = Integer.MIN_VALUE;
		for(int i = 1; i < N+1; i++) {
			max = Math.max(max, dist[i]);
		}
		System.out.println(Arrays.toString(dist));
		
	}
}
