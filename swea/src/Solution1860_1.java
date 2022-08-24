import java.util.Arrays;
import java.util.Scanner;

public class Solution1860_1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 테스트케이스
		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt(); // 손님 수
			int M = sc.nextInt(); // 걸리는 시간
			int K = sc.nextInt(); // 만드는 개수
			String ans = "Possible";
			int P = 0; // 붕어빵 받은 사람 수

			// 손님오는 시간 받아서 배열로 만들기
			int[] arr = new int[N];
			for (int i = 0; i < N; i++) {
				arr[i] = sc.nextInt();
			}

			Arrays.sort(arr);

			// 그 손님이 오는 시간에 만들어진 붕어빵 수가 이미 온 손님의 수보다 많을 때만 가능
			for (int j = 0; j < N; j++) {
				if ((arr[j] / M) * K > P) {
					P++;
				} else {
					ans = "Impossible";
					break;
				}
			}
			System.out.println("#" + t + " " + ans);
		}
	}
}