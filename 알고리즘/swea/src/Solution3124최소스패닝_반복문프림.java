import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution3124최소스패닝_반복문프림 {
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());

			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());

			int[][] adjArr = new int[V][V];

			// 간선 입력받을거다
			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				int s = Integer.parseInt(st.nextToken())-1;
				int e = Integer.parseInt(st.nextToken())-1;
				int w = Integer.parseInt(st.nextToken());

				adjArr[s][e] = w;
				adjArr[e][s] = w;
			} // 입력

			boolean[] visited = new boolean[V]; // 정점 방문했는지 확인용
			int[] dist = new int[V];
			int[] p = new int[V];

			Arrays.fill(dist, Integer.MAX_VALUE);

			// 0부터 시작하자
			dist[0] = 0;
			p[0] = -1;

			int ans = 0;
			// 프림을 만들어보자
			for (int i = 0; i < V; i++) {
				int min = Integer.MAX_VALUE;
				int idx = -1;

				// 아직 안뽑힌 사람 중에 제일 작은 값을 찾는다.
				for (int j = 0; j < V; j++) {
					if (!visited[j] && dist[j] < min) {
						min = dist[j];
						idx = j;
					}
				}
				visited[idx] = true;
				// 연결된 아이들 거리 갱신
				for (int j = 0; j < V; j++) {
					if (!visited[j] && adjArr[idx][j] != 0 && dist[j] > adjArr[idx][j]) {
						dist[j] = adjArr[idx][j];
						p[j] = idx;
					}
				}

			}
			for (int i = 0; i < V; i++) {
				ans += dist[i];
			}
			System.out.println("#" + t + " " + ans);
		}
	}
}
