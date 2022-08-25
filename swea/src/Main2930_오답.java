import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2930_오답 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		// 테스트케이스
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			System.out.print("#" + t + " ");

			// 연산 횟수
			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[N * 3];
			int index = 0; // 배열에 몇개가 들어가있는지

			for (int n = 0; n < N; n++) {
				st = new StringTokenizer(br.readLine());

				int num = Integer.parseInt(st.nextToken());

				// 1이면 배열에 넣기
				if (num == 1) {
					arr[++index] = Integer.parseInt(st.nextToken());
					int tmp = index;
					// 정렬하기
					while (tmp / 2 != 0) {
						if (arr[tmp] > arr[tmp / 2]) {
							int tmp2 = arr[tmp];
							arr[tmp] = arr[tmp / 2];
							arr[tmp / 2] = tmp2;
							tmp /= 2;
						}
					}
				} else {
					if (index == 0)
						System.out.print("-1" + " ");
					else {
						System.out.print(arr[1] + " ");
						arr[1] = arr[index];
						arr[index] = 0;
						index--;
						// 정렬하기
						int tmp = 1;

						while (tmp <= index) {
							if (arr[tmp] < Math.max(arr[tmp * 2 + 1], arr[tmp * 2 + 1])) {
								if (arr[tmp * 2] > arr[tmp * 2 + 1]) {
									int tmp2 = arr[tmp * 2];
									arr[tmp * 2] = arr[tmp];
									arr[tmp] = tmp2;
									tmp *= 2;
								} else {
									int tmp2 = arr[tmp * 2 + 1];
									arr[tmp * 2 + 1] = arr[tmp];
									arr[tmp] = tmp2;
									tmp = (tmp * 2) + 1;
								}
							}
						}
					}
				}
			}
			System.out.println();
		}
		br.close();
	}
}
