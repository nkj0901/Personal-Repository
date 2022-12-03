import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main11724연결요소개수 {

	static class Node {
		int s, e;

		Node(int s, int e) {
			this.s = s;
			this.e = e;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		list = new ArrayList[N + 1];
		check = new boolean[N + 1];

		for (int i = 0; i <= N; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());

			list[s].add(new Node(s, e));
			list[e].add(new Node(e, s));
		}
		
		int ans = 0;
		for (int i = 1; i <= N; i++) {
			if (!check[i]) {
				ans++;
				dfs(i);
			}
		}
		System.out.println(ans);
	}

	static List<Node>[] list;
	static boolean[] check;

	private static void dfs(int n) {
		for (int i = 0; i < list[n].size(); i++) {
			int tmp = list[n].get(i).e;
			if(!check[tmp]) {
			check[tmp]=true;
			dfs(tmp);
			}
		}
	}
}
