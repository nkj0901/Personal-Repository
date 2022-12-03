import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution1267작업순서 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		for (int t = 1; t <= 10; t++) {

			st = new StringTokenizer(br.readLine());

			int V = Integer.parseInt(st.nextToken()); // 정점수
			int E = Integer.parseInt(st.nextToken()); // 간선수

			// 진입차수 세줄 아이
			int[] count = new int[V + 1];
			List<Integer>[] list = new ArrayList[V + 1];

			for (int i = 0; i <= V; i++) {
				list[i] = new ArrayList<>();
			}

			st = new StringTokenizer(br.readLine());
			int s, e;
			for (int i = 0; i < E; i++) {
				s = Integer.parseInt(st.nextToken());
				e = Integer.parseInt(st.nextToken());
				list[s].add(e);
				count[e]++;
			}

			Queue<Integer> queue = new LinkedList<Integer>();

			for (int i = 1; i <= V; i++) {
				if (count[i] == 0) {
					queue.add(i);
				}
			}
			
//			System.out.println(Arrays.toString(count));
			
			System.out.print("#" + t + " ");
			while (!queue.isEmpty()) {
				int n = queue.poll();
				System.out.print(n + " ");

				// n이 진출하는 모든 아이들의 count 배열의 cnt를 줄여줘
				for (int l : list[n]) {
					count[l]--;

					if (count[l] <= 0) {
						queue.add(l);
					}
				}
			}
			System.out.println();
		}
	}
}
