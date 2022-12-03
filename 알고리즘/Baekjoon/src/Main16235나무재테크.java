import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main16235나무재테크 {

	static class Tree implements Comparable<Tree> {
		int age;
		boolean live;

		Tree(int age, boolean live) {
			this.age = age;
			this.live = live;
		}

		@Override
		public int compareTo(Tree o) {
			return Integer.compare(this.age, o.age);
		}
	}

	static int N;
	static int[][] ground;
	static int[][] groundcopy;
	static List<Tree>[][] tree;
	static int[] dr = { -1, -1, -1, 0, 1, 1, 1, 0 };
	static int[] dc = { -1, 0, 1, 1, 1, 0, -1, -1 };
	static PriorityQueue<Tree> pq;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		ground = new int[N][N];
		groundcopy = new int[N][N]; // 겨울에 양분 줄 때 쓸 것
		tree = new ArrayList[N][N];
		pq = new PriorityQueue<>();
		
		
		//양분 다 5로 만들기
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				ground[i][j] = 5;
			}
		}
		

		// tree배열 list로 초기화 시키기
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				groundcopy[i][j] = Integer.parseInt(st.nextToken());
				tree[i][j] = new ArrayList<Tree>();
			}
		}

		// 나무 심기
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken()) - 1;
			Tree namu = new Tree(Integer.parseInt(st.nextToken()), true);
			tree[r][c].add(namu);
		}

		// K만큼 함수 실행 반복
		for (int i = 0; i < K; i++) {
			spring();
			summer();
			fall();
			winter();
		}

		int ans = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				ans += tree[i][j].size();
			}
		}
		System.out.println(ans);

	}// main

	// 봄
	static void spring() {
		// 배열 순회하면서 거기에 있는 나무들 볼 것
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				pq.addAll(tree[i][j]);

				// 나이가 어린 애부터 튀어나올 거다
				while (!pq.isEmpty()) {
					Tree t = pq.poll();

					if (ground[i][j] - t.age >= 0) {
						ground[i][j] -= t.age;
						t.age+=1;
					} else {
						t.live = false; // 영양분 없어서 죽어따
					}
				}
			}
		}
	}

	// 여름
	static void summer() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {

				for (int z = 0; z < tree[i][j].size(); z++) {
					if (tree[i][j].get(z).live == false) {
						ground[i][j] += tree[i][j].get(z).age / 2;
						tree[i][j].remove(z);
						z--;
					}
				}
			}
		}
	}

	// 가을
	static void fall() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {

				// 5로 나눠지면 팔방에 애기 나무 심기
				for (int a = 0; a < tree[i][j].size(); a++) {
					if (tree[i][j].get(a).age % 5 == 0) {
						for (int b = 0; b < 8; b++) {
							int nr = i + dr[b];
							int nc = j + dc[b];

							if (nr < 0 || nc < 0 || nr >= N || nc >= N)
								continue;

							Tree t = new Tree(1, true);
							tree[nr][nc].add(t);
						}
					}
				}
			}
		}

	}

	// 겨울
	static void winter() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				ground[i][j] += groundcopy[i][j];
			}
		}
	}

}
