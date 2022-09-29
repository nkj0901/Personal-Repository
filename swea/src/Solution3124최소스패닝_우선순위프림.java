import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution3124최소스패닝_우선순위프림 {

	static class Edge implements Comparable<Edge> {
		int st, ed, cost;

		public Edge(int st, int ed, int cost) {
			this.st = st;
			this.ed = ed;
			this.cost = cost;
		}

		@Override
		public int compareTo(Edge o) {
			return this.cost - o.cost;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());

			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());

			List<Edge>[] adjList = new ArrayList[V];
			for(int i = 0; i < V; i++) {
				adjList[i] = new ArrayList<>();
			}
			// 간선 입력받을거다
			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				int s = Integer.parseInt(st.nextToken())-1;
				int e = Integer.parseInt(st.nextToken())-1;
				int w = Integer.parseInt(st.nextToken());

				adjList[s].add(new Edge(s, e, w));
				adjList[e].add(new Edge(e, s, w));
				
			} // 입력
			boolean[] visited = new boolean[V]; // 정점 방문했는지 확인용
			PriorityQueue<Edge> pq = new PriorityQueue<>();
			// 0부터 시작하자
			visited[0] = true;
			
			pq.addAll(adjList[0]);

			int pick = 0; //고른 정점 개수
			long ans = 0;
			
			while(!pq.isEmpty()) {
				Edge edge = pq.poll();
				if(visited[edge.ed])continue;
				
				ans+= edge.cost;
				pq.addAll(adjList[edge.ed]);
				visited[edge.ed] = true;
				pick++;
			}
			bw.write("#" + t + " " + ans + "\n");
		}
		bw.flush();
		br.close();
		bw.close();
	}
}
