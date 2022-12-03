import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Solution2383점심식사시간 {

	static class Node {
		int r, c;

		Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	static class stair {
		int r, c, time;

		stair(int r, int c, int time) {
			this.r = r;
			this.c = c;
			this.time = time;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {

			int N = Integer.parseInt(br.readLine());
			// 사람 담을 배열
			people = new ArrayList<>();
			stairs = new ArrayList<>();
			first = new ArrayList<>();
			second = new ArrayList<>();

			// 사람과 계단의 위치를 받아오기
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					int tmp = Integer.parseInt(st.nextToken());
					if (tmp == 1) {
						people.add(new Node(i, j));
					} else if (tmp > 1) {
						stairs.add(new stair(i, j, tmp));
					}
				}
			}
//			System.out.println(stairs.get(0).r + " " + stairs.get(0).c);
//			System.out.println(stairs.get(1).r + " " + stairs.get(1).c);

//			visited = new boolean[people.size()];
			min = Integer.MAX_VALUE;
			dfs(0, 0, 0);
			bw.write("#" + t + " " + min + "\n");
		} // tc
		bw.flush();
		br.close();
		bw.close();
	} // main

	static List<Node> people;
	static List<stair> stairs;
	static List<Node> first; // 첫번째 계단 선택한 애들
	static List<Node> second;// 두번째 계단 선택한 애들
//	static boolean[] visited;
	static int min;

	private static void dfs(int n, int fir, int sec) {

		if (n == people.size()) {
//			for (int i = 0; i < first.size(); i++) {
//				System.out.print(first.get(i).r + " " + first.get(i).c+ "  ");
//			}
//			System.out.println();
//			for (int i = 0; i < second.size(); i++) {
//				System.out.print(second.get(i).r + " " + second.get(i).c+ "  ");
//			}
//			System.out.println();
			countTime();
			return;
		}

		first.add(people.get(n));
		dfs(n + 1, fir + 1, sec);
		first.remove(fir);
		second.add(people.get(n));
		dfs(n + 1, fir, sec + 1);
		second.remove(sec);
	}

	private static void countTime() {
		int time1 = 1;
		int time2 = 1;

		List<Integer> f = new ArrayList<>(); // 걸리는 시간으로 바꿔 넣어줌
		List<Integer> fs = new ArrayList<>(); // 계단에 있는 애들
		stair firstStair = stairs.get(0);
		//거리구하기
		for (int i = 0; i < first.size(); i++) {
			Node n = first.get(i);
			f.add(Math.abs(n.r - firstStair.r) + Math.abs(n.c - firstStair.c));
		}
		
//		for(int i = 0; i < f.size();i++) {
//			System.out.print(f.get(i)+ " ");
//		}
//		System.out.println();

		List<Integer> s = new ArrayList<>(); // 걸리는 시간으로 바꿔 넣어줌
		List<Integer> ss = new ArrayList<>(); // 계단에 있는 애들
		stair secondStair = stairs.get(1);
		for (int i = 0; i < second.size(); i++) {
			Node n = second.get(i);
			s.add(Math.abs(n.r - secondStair.r) + Math.abs(n.c - secondStair.c));
		}
		
		//시간구하기
		while (true) {
			

			for (int i = fs.size() - 1; i >= 0; i--) {
				fs.set(i, fs.get(i) - 1);
				if (fs.get(i) == 0) {
					fs.remove(i);
				}
			}

			for (int i = f.size() - 1; i >= 0; i--) {
//				System.out.println("-1하기 전 "+f.get(i) );
				f.set(i, f.get(i) - 1);
//				System.out.println(i + " -1한 값 " + f.get(i));
//				System.out.println("시간 " + time1);
				if (f.get(i) <= 0 && fs.size() < 3) {
					fs.add(stairs.get(0).time);
					f.remove(i);
				}
			}
			time1++;
			if (f.size() == 0 && fs.size() == 0)
				break;
		}

//		System.out.println(s.size());
//		System.out.println(ss.size());
		while (true) {
			
			for (int i = ss.size() - 1; i >= 0; i--) {
				ss.set(i, ss.get(i) - 1);
				if (ss.get(i) == 0) {
					ss.remove(i);
				}
			}

			for (int i = s.size() - 1; i >= 0; i--) {
				s.set(i, s.get(i) - 1);
				if (s.get(i) <= 0 && ss.size() < 3) {
					ss.add(stairs.get(1).time);
					s.remove(i);
				}
			}
			time2++;
			if (s.size() == 0 && ss.size() == 0)
				break;
		}
		min = Math.min(Math.max(time1, time2), min);
//		System.out.println("지금까지 나온 답 " + time1 + " " + time2 + " " + min);
	}
}
