import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main16236아기상어 {

	static class Node {
		int r, c, size;

		Node(int r, int c, int size) {
			this.r = r;
			this.c = c;
			this.size = size;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		map = new int[N][N];

		int ans = 0;
		sharkSize = 2;
		sharkR = 0;
		sharkC = 0;
		int eat = 0;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());

				if (map[i][j] == 9) {
					sharkR = i;
					sharkC = j;
					map[i][j] = 0;
				}
			}
		}

		while (true) {
			list = new ArrayList<>();

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] > 0) {
						list.add(new Node(i, j, map[i][j]));
					}
				}
			}

//				for(int i = 0; i < list.size(); i++) {
//					System.out.println(list.get(i).r + " " + list.get(i).c);
//				}

//			for (int[] a : map) {
//				System.out.println(Arrays.toString(a));
//			}

			if (list.size() == 0)
				break;

			sizeList = new ArrayList<>();

			min = Integer.MAX_VALUE;
			for (int i = 0; i < list.size(); i++) {
				Node node = list.get(i);

				// 같은 크기 이거나 더 큰 애면 패스
				if (node.size >= sharkSize) {
					continue;
				}

				// 젤 가까운애 갱신
				int dist = Math.abs(sharkR - node.r) + Math.abs(sharkC - node.c);
				if (min > dist) {
					sizeList.clear();
					min = dist;
					sizeList.add(node);
				} else if (min == dist) {
					sizeList.add(node);
				}
			}

			// 먹을 수 있는 애가 없다는 소리
			if (sizeList.size() == 0)
				break;

			// r끼리 비교하겠다.
			sizeList2 = new ArrayList<>();
			if (sizeList.size() > 1) {

				min = Integer.MAX_VALUE;
				getMini(sizeList);

			} else if (sizeList.size() == 1) {
				Node node = sizeList.get(0);
				visited = new boolean[N][N];
				distance = Integer.MAX_VALUE;

				getDistance(sharkR, sharkC, node.r, node.c, 0);
				distance= distance == Integer.MAX_VALUE ? 0 : distance;
//				System.out.println("나는 디스턴스 " + distance);
				ans+=distance;
				sharkR = node.r;
				sharkC = node.c;
				map[node.r][node.c] = 0;
				eat++;
			}

			// c끼리 비교하겠다.
			min = Integer.MAX_VALUE;
			
			if (sizeList2.size() > 0) {
				for (int i = 0; i < sizeList2.size(); i++) {

					min = Integer.MAX_VALUE;
					minC = null;
					getMini(sizeList2);
				}
				visited = new boolean[N][N];
				distance = Integer.MAX_VALUE;
				getDistance(sharkR, sharkC, minC.r, minC.c, 0);
				distance = distance == Integer.MAX_VALUE ? 0 : distance;
				
				ans+=distance;
//				System.out.println("나는 디스턴스 " + distance);
				sharkR = minC.r;
				sharkC = minC.c;
				map[minC.r][minC.c] = 0;
				eat++;
			}

			if (eat == sharkSize) {
				sharkSize++;
				eat = 0;
			}
		}

		System.out.println(ans);
	}

	static int[][] map;
	static List<Node> list, sizeList, sizeList2;
	static boolean[][] visited;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static int sharkSize, N, sharkR, sharkC, distance, min;
	static Node minC;

	private static void getMini(List<Node> sizeList) {

		for (int i = 0; i < sizeList.size(); i++) {
			Node node = sizeList.get(i);
			if (node.r < min) {
				sizeList2.clear();
				min = node.r;
				minC = node;
				sizeList2.add(node);
			} else if (node.r == min) {
				sizeList2.add(node);
			}
		}
	}

	// dfs
	private static void getDistance(int SR, int SC, int r, int c, int cnt) {
//		System.out.println(SR + " " + SC);
//		System.out.println("상어 위치" + sharkR + " " + sharkC + " " + sharkSize);
		if (SR == r && SC == c) {
			distance = Math.min(distance, cnt);
//			System.out.println("안녕" + distance);
			return;
		}

		for (int d = 0; d < 4; d++) {
			int nr = SR + dr[d];
			int nc = SC + dc[d];

			if (nr < 0 || nc < 0 || nr >= N || nc >= N)
				continue;
			if (visited[nr][nc])
				continue;
			visited[nr][nc] = true;
			if (map[nr][nc] > sharkSize)
				continue;
			getDistance(nr, nc, r, c, cnt + 1);
			visited[nr][nc] = false;

		}
	}
}
