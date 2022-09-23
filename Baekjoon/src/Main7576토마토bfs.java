import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main7576토마토bfs {
	static int r, c;

	static class Node {
		int r, c;

		Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		c = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());

		int[][] map = new int[r][c];
		boolean[][] visited;

		for (int i = 0; i < r; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < c; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		Queue<Node> queue = new LinkedList<Node>();
		int[] dr = { 0, -1, 0, 1 };
		int[] dc = { -1, 0, 1, 0 };
		int days = 0;
		// 0이 있으면 check를 false로 바꿀 것.
		// 0이 없어서 check가 그대로 이면 멈출 것.
		// 배열 순회하면서 1을 찾는다.
		boolean flag1 = true;
		boolean flag = true;
		
		while (true) {
			//다 1이면 끝내
			if (flag1 == false)
				break;
			days++;
			flag = false;
			flag1 = false;
			
			visited = new boolean[r][c];
			
			//돌리기 전의 모습을 저장
			int[][] tmp = map;

			// 하루가 지나면 visited배열을 초기화해주고 다시 탐색을 한다.
			for (int i = 0; i < r; i++) {
				for (int j = 0; j < c; j++) {

					// 찾으면 큐에 넣어준다.
					if (map[i][j] == 1 && visited[i][j] == false) {
						queue.add(new Node(i, j));
						visited[i][j] = true;
						// while문(큐가 비면 종료) 돌리면서 for문 돌려서 또 visited가 아닌 1일 찾고
						while (!queue.isEmpty()) {
							Node node = queue.poll();

							// 그 부분을 중심으로 4방탐색을 하여 1로 바꿔주고 visited배열에 체크해준다.
							for (int d = 0; d < 4; d++) {
								int nr = node.r + dr[d];
								int nc = node.c + dc[d];

								// 일이고 방문하지 않았던 곳이어야만 보기
								if (nr >= 0 && nr < r && nc >= 0 && nc < c) {
									if (map[nr][nc] == 1 && visited[nr][nc] == false) {
										// 방문표시
										visited[nr][nc] = true;
										queue.add(new Node(nr, nc));
									} else if (map[nr][nc] == 0) {
										map[nr][nc] = 1;
										// 트루이면 옆에 것 못익게 막는 것
										visited[nr][nc] = true;
										flag = true;
										flag1 = true;
									}
								}
								// 볼 수 있는 곳이 없어서 큐가 비면 종료 다음날로 넘어감
							}
						}
					} else if (map[i][j] == 0) flag1 = true;
				}
			}
			
			if (flag == false) {
				days = -1;
				break;
			}
		}
		bw.write(days + " ");
		bw.flush();
		br.close();
		bw.close();
	}

//	static boolean viewAll(int[][] arr) {
//		for (int i = 0; i < r; i++) {
//			for (int j = 0; j < c; j++) {
//				if (arr[i][j] == 0)
//					return false;
//			}
//		}
//		return true;
//	}
}
