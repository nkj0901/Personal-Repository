import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution2930 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		// 테스트케이스
		int T = Integer.parseInt(br.readLine());

 		for (int t = 1; t <= T; t++) {
			System.out.print("#" + t + " ");

			// 연산횟수
			int N = Integer.parseInt(br.readLine());
			// 배열만들기
			int[] arr = new int[N * 2 + 1];
			int size = 0;

			for (int n = 0; n < N; n++) {
				st = new StringTokenizer(br.readLine());
				int sel = Integer.parseInt(st.nextToken());
				if (sel == 1) {
					if (size == 0) {
						arr[++size] = Integer.parseInt(st.nextToken());
						// 제일 큰 값을 루트로 정렬해줘야 함
					} else {
						arr[++size] = Integer.parseInt(st.nextToken());
						int idx = size;
						while (idx > 1) {
							if (arr[idx] > arr[idx / 2]) {
								int tmp = arr[idx];
								arr[idx] = arr[idx / 2];
								arr[idx / 2] = tmp;
								idx = idx / 2;
							}else {
								break;
							}
						}
					}
				} else {
					//트리에 아무것도 없다면 -1 출력
					if (size == 0)
						System.out.print("-1" + " ");
					else {
						System.out.print(arr[1] + " ");
						arr[1] = arr[size];
						int idx = 1;
						arr[size]=0;
						size--;
						
						while (idx < size) {
						if (arr[idx] < arr[idx * 2] || arr[idx] <arr[idx * 2 + 1]) {
							if (arr[idx * 2] > arr[idx * 2 + 1]) {
								int tmp = arr[idx * 2];
								arr[idx * 2] = arr[idx];
								arr[idx] = tmp;
								idx = idx * 2;
							} else {
								int tmp = arr[idx * 2 + 1];
								arr[idx * 2 + 1] = arr[idx];
								arr[idx] = tmp;
								idx = idx * 2 + 1;
							}
							} else {
								break;
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
