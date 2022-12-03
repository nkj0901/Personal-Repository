import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main1260DFS와BFS {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); //정점의 개수
		int M = Integer.parseInt(st.nextToken()); //간선의 개수
		int V = Integer.parseInt(st.nextToken()); //시작정점
		list = new ArrayList[N+1];
		check = new boolean[N+1];
		
		
		for(int i = 0; i < N+1; i++) {
			list[i] = new ArrayList();
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			list[s].add(e);
			list[e].add(s);
		}
		
		//정렬해주자(작은애부터 들려야 하니까)
		for(int i = 1; i < N+1; i++) {
		Collections.sort(list[i]);
		}
		
		System.out.print(V+" ");
		check[V] = true;
		dfs(V);
		System.out.println();
		
		check = new boolean[N+1];
		queue = new LinkedList<Integer>();
		System.out.print(V+" ");
		bfs(V);
	}
	static List<Integer>[] list;
	static boolean[] check;
	static Queue<Integer> queue;
	
	private static void bfs(int v) {
		
		check[v] = true;
		queue.addAll(list[v]);
		
		while(!queue.isEmpty()) {
			int n = queue.poll();
			
			if(check[n]) continue;
			check[n] = true;
			System.out.print(n+" ");
			queue.addAll(list[n]);
		}
	}
	private static void dfs(int v) {
		
		for(int i = 0; i < list[v].size(); i++) {
			int n = list[v].get(i);
			
			if( check[n]) continue;
			check[n] = true;
			System.out.print(n + " ");
			dfs(n);
		}
	}
}
