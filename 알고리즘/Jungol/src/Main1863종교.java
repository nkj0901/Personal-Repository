import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main1863종교 {
	static int N;
	static int[] p;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		p = new int[N];
		// 메이크셋
		for (int i = 0; i < N; i++) {
			p[i] = i;
		}

		// 간선을 받을거야
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken()) - 1;
			int e = Integer.parseInt(st.nextToken()) - 1;

			union(s, e);
		}

		Set<Integer> set = new HashSet<>();
		for (int tmp : p) {
			set.add(findSet(tmp));
		}
		System.out.println(set.size());
	}

	private static void union(int s, int e) {
		int px = findSet(s);
		int py = findSet(e);

		if (px != py) {
			p[py] = p[px];
		}
	}

	static int findSet(int x) {
		if (x == p[x])
			return x;
		else
			return p[x] = findSet(p[x]);
	}

}
