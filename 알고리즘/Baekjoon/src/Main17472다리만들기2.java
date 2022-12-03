import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main17472다리만들기2 {
	static int[][] map;
	//섬 번호 매기기 위한 아이들
	static int R, C, island,ans, anscnt;
	
	static Queue<Node> queue = new LinkedList<>();
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static boolean[][] visited;
	
	static class Node {
		int r, c, num;		
		Node(int r, int c, int num) {
			this.r = r;
			this.c = c;
			this.num = num;
		}
	}
	
	//거리구하기 위한 아이
	static List<Node2>[] dist;
	
	//프림을 위한 아이들
	static PriorityQueue<Node2> pq;
	static boolean[] pqVisited;
	static class Node2 implements Comparable<Node2> {
		int s, e, w;
		
		Node2(int s, int e, int w) {
			this.s = s;
			this.e = e;
			this.w = w;
		}
		
		@Override
		public int compareTo(Node2 o) {
			return Integer.compare(this.w, o.w);
		}
		
		@Override
		public String toString() {
			return "Node2 [s=" + s + ", e=" + e + ", w=" + w + "]";
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new int[R][C];

		// 배열채우기
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 섬에 번호 매기기
		visited = new boolean[R][C];
		bfs();
		
//		for (int[] a : map) {
//			System.out.println(Arrays.toString(a));
//		}

		// 섬사이의 모든 거리 구하기
		// 배열 초기화
		dist = new ArrayList[island + 1];
		for(int i = 0 ; i < island+1; i++) {
			dist[i] = new ArrayList<>();
		}
		
		distance(); //섬 거리 다 구해서 인접리스트로 만들기

		//우선순위 큐로 짧은 거리 뽑아내기
		//큐, 배열 초기화
		pq = new PriorityQueue<>();
		pqVisited = new boolean[island+1];
		
		//프림 시작
		pq.addAll(dist[1]);
		pqVisited[1] = true;
		ans = 0;
		anscnt = 0;
		prim();
		
		//답 출력
		if(anscnt < island-1) ans = -1;
		System.out.println(ans);
	}

	private static void bfs() {
		island = 0;
		// 돌면서 1인 것들 큐에 넣기
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				// 1이고 방문하지 않은 것들만 넣기
				if (map[i][j] == 1 && !visited[i][j]) {
					queue.add(new Node(i, j, ++island));
					map[i][j] = island;

					while (!queue.isEmpty()) {
						Node n = queue.poll();

						if (visited[n.r][n.c])
							continue;

						visited[n.r][n.c] = true;

						for (int d = 0; d < 4; d++) {
							int nr = n.r + dr[d];
							int nc = n.c + dc[d];

							if (nr < 0 || nr >= R || nc < 0 || nc >= C)
								continue;

							if (visited[nr][nc] || map[nr][nc] == 0)
								continue;

							queue.add(new Node(nr, nc, n.num));
							map[nr][nc] = n.num;
						}
					}
				}
			}
		}
	}

	private static void distance() {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {

				if (map[i][j] >= 1) {

					for (int d = 0; d < 4; d++) {
						int cnt = 0;
						int idx = 1;
						while (true) {
							int nr = i + dr[d] * idx;
							int nc = j + dc[d] * idx;

							if (nr < 0 || nr >= R || nc < 0 || nc >= C)
								break;

							if (map[nr][nc] == 0) {
								++cnt;
							} else {
								if(cnt > 1) {
								dist[map[i][j]].add(new Node2(map[i][j], map[nr][nc], cnt));
								dist[map[nr][nc]].add(new Node2(map[nr][nc], map[i][j], cnt));
								}
								break;
							}
							idx++;
						}
					}
				}
			}
		}
	}
	
	private static void prim() {
		
		while(!pq.isEmpty()) {
			Node2 n = pq.poll(); //젤 짧은 애가 뽁나옴
			
			if(pqVisited[n.e]) continue;
			
			pqVisited[n.e] = true;
			
			ans+=n.w;
			anscnt++;
			
			pq.addAll(dist[n.e]);
		}
		
	}

}
