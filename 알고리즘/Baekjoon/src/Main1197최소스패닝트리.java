import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main1197최소스패닝트리 {

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

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		List<Edge>[] adjArr = new ArrayList[V];
		
		//인접리스트 초기화
		for(int i = 0; i < V; i++) {
			adjArr[i] = new ArrayList<>();
		}
		
		//이제 리스트 채우자
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken())-1;
			int e = Integer.parseInt(st.nextToken())-1;
			int w = Integer.parseInt(st.nextToken());
			
			adjArr[s].add(new Edge(s, e, w));
			adjArr[e].add(new Edge(e, s, w));
		} //입력완료
		//이제 정점 한개씩 보면서 제일 작은 값을 선택할 것
		boolean[] visited = new boolean[V];
		
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		
		pq.addAll(adjArr[0]);
		visited[0] = true;
		int pick = 1;
		long ans = 0;
		
		while(pick != V) {
			Edge edge = pq.poll();
			if(visited[edge.ed]) continue;
			
			ans+=edge.cost;
			pq.addAll(adjArr[edge.ed]);
			visited[edge.ed] = true;
			pick++;
		}
		System.out.println(ans);
	}
}
