import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main1753최단경로 {

	static class Node implements Comparable<Node> {
		int v;
		int weight;

		public Node(int v, int weight) {
			this.v = v;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.weight, o.weight);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(br.readLine()) - 1;

		List<Node>[] adjArr = new ArrayList[V];

		for (int i = 0; i < V; i++) {
			adjArr[i] = new ArrayList<>();
		}

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken()) - 1;
			int e = Integer.parseInt(st.nextToken()) - 1;
			int w = Integer.parseInt(st.nextToken());

			adjArr[s].add(new Node(e, w));
		} // 입력 끝

		PriorityQueue<Node> pq = new PriorityQueue<>();
		boolean[] check = new boolean[V];
		int[] dist = new int[V];
		Arrays.fill(dist, Integer.MAX_VALUE);

		// 0번부터 넣어준다
		pq.add(new Node(start, 0));
		dist[start] = 0;

		while (!pq.isEmpty()) {
			Node curr = pq.poll();

			if (check[curr.v])
				continue;
			check[curr.v] = true;

			for (Node n : adjArr[curr.v]) {
				if (!check[n.v] && dist[n.v] > dist[curr.v] + n.weight) {
					dist[n.v] = dist[curr.v] + n.weight;
					pq.add(new Node(n.v, dist[n.v]));
				}
			}
		}
		for (int a : dist) {
			if (a == Integer.MAX_VALUE) {
				System.out.println("INF");
			} else {
				System.out.println(a);
			}
		}
	}
}
