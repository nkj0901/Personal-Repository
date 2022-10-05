import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution최빈수 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();

		// 테스트케이스만큼 돌거다
		for (int tc = 1; tc <= t; tc++) {
			List<Integer> arr = new ArrayList<Integer>();

			// 테스트 케이스 번호
			int a = sc.nextInt();

			int max = 0;
			int maxscore = 0;
			// 학생 천명의 점수를 받을거야
			for (int s = 0; s < 1000; s++) {
				int score = sc.nextInt();
				int cnt = 0;
				arr.add(score);

				for (int i = 0; i < arr.size(); i++) {
					// arr에 score 가 몇번있나 체크
					if (score == arr.get(i)) {
						cnt++;
						// 만약 cnt가 기존가지고 있던 max보다 크면 maxscore에 방금 입력한 score을 담을 거야
					}

					if (max <= cnt) {
						if (max == cnt) {
							int m;
							m = Math.max(score, maxscore);
							maxscore = m;
							max = cnt;
						} else {
							maxscore = score;
							max = cnt;
						}
					}
				}
			}
			System.out.println("#" + a + " " + maxscore);
		}
	}
}