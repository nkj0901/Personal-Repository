import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main지수언니꺼 {
	static class Edge implements Comparable<Edge> {
		int st, ed, cost;

		public Edge(int st, int ed, int cost) {
			this.st = st;
			this.ed = ed;
			this.cost = cost;
		}

		// 우선순위큐를 활용하기 위해서 기준을 정해준다.
		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.cost, o.cost);
		}

		@Override
		public String toString() {
			return "Edge [st=" + st + ", ed=" + ed + ", cost=" + cost + "]";
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int V = sc.nextInt(); // V : 정점의 개수 0부터 시작을 하더라
		int E = sc.nextInt(); // E : 간선의 수
		int startV = sc.nextInt() - 1;

		// 인접리스트 초기화
		List<Edge>[] adjList = new ArrayList[V];
		for (int i = 0; i < V; i++)
			adjList[i] = new ArrayList<>();

		for (int i = 0; i < E; i++) {
			int st = sc.nextInt() - 1; // 시작정점
			int ed = sc.nextInt() - 1; // 도착정점
			int w = sc.nextInt(); // 가중치

			adjList[st].add(new Edge(st, ed, w));
		} // 입력

		boolean[] visited = new boolean[V];
		PriorityQueue<Edge> pq = new PriorityQueue<>();

		// 시작 정점을 하나 뽑아야해.
		visited[startV] = true;

		pq.addAll(adjList[startV]);

		int[] ans = new int[V];
		Arrays.fill(ans, Integer.MAX_VALUE);
		ans[startV] = 0;
		while (!pq.isEmpty()) {
			Edge edge = pq.poll();
			if (visited[edge.ed])
				continue;

			ans[edge.ed] = edge.cost;
			pq.addAll(adjList[edge.ed]);
			visited[edge.ed] = true;
		}

		for (int i = 0; i < V; i++) {
			if (ans[i] == Integer.MAX_VALUE) {
				System.out.println("INF");
			}
			System.out.println(ans[i]);
		}

	}// main
}
