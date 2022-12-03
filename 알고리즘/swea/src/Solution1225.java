import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution1225 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (sc.hasNext()) {
			Queue<Integer> q = new LinkedList<>();

			// 테스트케이스 입력
			int T = sc.nextInt();

			// 배열 만들기
			for (int i = 0; i < 8; i++) {
				q.offer(sc.nextInt());
			}

			loop: while (true) {
				for (int i = 1; i <= 5; i++) {
					int tmp = q.poll() - i;
					
					if (tmp <= 0) {
						q.offer(0);
						break loop;
					} else {
						q.offer(tmp);
					}
				}
			}

			System.out.print("#" + T + " ");
			for (int j = 0; j < 8; j++) {
				System.out.print(q.poll() + " ");
			}
			System.out.println();
		}
	}
}
