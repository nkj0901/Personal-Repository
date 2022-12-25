import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main1238파티_다잌스트라 {

	static class Node implements Comparable<Node> {
		int v, w;

		Node(int v, int w) {
			this.v = v;
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
		N = Integer.parseInt(st.nextToken()); // 도시, 학생수
		int M = Integer.parseInt(st.nextToken()); // 도로 개수
		X = Integer.parseInt(st.nextToken()); // 시작점

		List<Node>[] go = new ArrayList[N + 1];
		List<Node>[] back = new ArrayList[N + 1];

		// 인접리스트 만들기
		for (int i = 1; i < N + 1; i++) {
			go[i] = new ArrayList<>();
			back[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			go[e].add(new Node(s, w));
			back[s].add(new Node(e, w));
		}
		int[] distTo = dijkstra(go);
		int[] distFrom = dijkstra(back);
		
		int max = 0;
		for(int i = 1; i < N+1; i++) {
			max = Math.max(max, distTo[i]+distFrom[i]);
		}
		System.out.println(max);
	}
	
	static int N, X;
	static int INF = 987654321;
	
	private static int[] dijkstra(List<Node>[] list) {
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(X, 0));
		
		boolean[] check = new boolean[N+1];
		int[] dist = new int[N+1];
		Arrays.fill(dist, INF);
		dist[X] = 0;
		
		while(!pq.isEmpty()) {
			//이 아이로 가는 최단 경로를 구해보자
			Node cur = pq.poll();
			
			if(check[cur.v]) continue;
			check[cur.v] = true;
			
			for(Node node : list[cur.v]) {
				if(!check[node.v] && dist[node.v] > dist[cur.v]+node.w) {
					dist[node.v] = dist[cur.v] + node.w;
					pq.add(new Node(node.v, dist[node.v]));
				}
			}
		}
		return dist;
	}
}