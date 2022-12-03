import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main17471게리맨더링 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());

		// 인구 수를 담는 배열만들기
		p = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			p[i] = Integer.parseInt(st.nextToken());
		}

		// 인접리스트 만들기
		// 리스트를 담는 배열 만들기
		adjList = new ArrayList[N];

		// 배열 초기화
		for (int i = 0; i < N; i++) {
			adjList[i] = new ArrayList<>();
		}

		// 배열 채우기
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			for (int j = 0; j < n; j++) {
				int tmp = Integer.parseInt(st.nextToken()) - 1;
				adjList[i].add(tmp);
			}
		}
		// 조합 시작
		check = new boolean[N];
		min = Integer.MAX_VALUE;
		Combi(0);
		if(min == Integer.MAX_VALUE) min = -1;
		System.out.println(min);
	}

	static int N, min;
	static int[] p;
	static List<Integer>[] adjList;
	static boolean[] check;

	private static void Combi(int n) {

		if (n == N) {
			if (Linked()) {
				Count();
			}
			return;
		}

		// 선택
		check[n] = true;
		Combi(n + 1);
		// 선택x
		check[n] = false;
		Combi(n + 1);
	}

	private static void Count() {
		int t = 0;
		int f = 0;
		
		for(int i = 0; i < N; i++) {
			if(check[i]) t+=p[i];
			else f+=p[i];
		}
		
		min = Math.min(min, Math.abs(t-f));
	}

	private static boolean Linked() {
		List<Integer> t = new ArrayList<>();
		List<Integer> f = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			if (check[i] == true) {
				t.add(i);
			} else {
				f.add(i);
			}
		}
		if (t.size() == N || t.size() == 0)
			return false;

		Queue<Integer> queue = new LinkedList<Integer>();

		queue.add(t.get(0));
		int count = 0;
		boolean[] check2 = new boolean[N];

		while (!queue.isEmpty()) {
			int n = queue.poll();
			if(check2[n]) continue;
			check2[n] = true;
			count++;

			for (int i = 0; i < adjList[n].size(); i++) {
				if (check[adjList[n].get(i)]) {
					queue.add(adjList[n].get(i));
				}
			}
		}
		if(count != t.size()) return false;
		
		queue.add(f.get(0));
		count = 0;
		check2 = new boolean[N];

		while (!queue.isEmpty()) {
			int n = queue.poll();
			if(check2[n]) continue;
			check2[n] = true;
			count++;

			for (int i = 0; i < adjList[n].size(); i++) {
				if (check[adjList[n].get(i)] == false) {
					queue.add(adjList[n].get(i));
				}
			}
		}
		if(count != f.size()) return false;
		return true;
	}
}

//https://data-make.tistory.com/501
