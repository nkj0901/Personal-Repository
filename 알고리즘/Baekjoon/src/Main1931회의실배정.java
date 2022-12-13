import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main1931회의실배정 {
	static class Node implements Comparable<Node> {
		int s, e;

		Node(int s, int e) {
			this.s = s;
			this.e = e;
		}

		@Override
		public int compareTo(Node o) {
			if(this.e == o.e) {
				return this.s - o.s;
			}
			return this.e - o.e;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		List<Node> list = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			list.add(new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}

		Collections.sort(list);
		
		int ans = 0;
		int E = 0;
		
		for (int i = 0; i < N; i++) {
//			System.out.println(list.get(i).s + " " + list.get(i).e);
			Node node = list.get(i);
			if(E<=node.s) {
				ans++;
				E = node.e;
			}
		}
		System.out.println(ans);
	}
}
