import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main1205 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// 숫자 개수
		int N = Integer.parseInt(br.readLine());

		// 배열에 수를 넣으며 조커 개수 세고 제일 큰 수와 제일 작은 수를 구하기(포문 돌리려고)
		boolean[] arr = new boolean[1000002];
		int zero = 0;
		int min = 1000001;
		int max = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int n = 0; n < N; n++) {
			int num = Integer.parseInt(st.nextToken());
			// 0개의 개수 세기
			if (num == 0) {
				zero++;
			} else {
				arr[num] = true;

				if (min > num)
					min = num;
				if (max < num)
					max = num;
			}
		}
		
		if (zero == N || zero == N - 1) {
			bw.append(N + "");
		} else if (zero == 0) { // 조커가 0개 이면.. 연속된 숫자만큼이 답
			int count = 0;
			int countmax = 1;
			for (int i = min; i <= max+1; i++) {
				if (arr[i] == true) {
					count++;
				} else {
					if (countmax < count) {
						countmax = count;
					}
					count = 0;
				}
			}
			bw.append(countmax + "");
		} else if (zero > 0) {
			int maxserial = 0;
			for (int i = min; i <= max; i++) {
				if (arr[i] == true) {

					// 해당 위치에서 조커를 썼을 때 길이가 몇까지 갈 수 있는지
					int tmpzero = zero;
					int index = i;
					int serial = 1;
					while (index + 1 <= 1000001) {
						if (arr[index + 1] == true)
							serial++;
						else { // 0이면 조커를 쓰자
								// 조커 없으면 멈춰
							if (tmpzero == 0)
								break;
							tmpzero--;
							serial++;
						}
						index++;
					}
					if (maxserial < serial) {
						maxserial = serial;
					}
				}
			}
			bw.append(maxserial + "");
		}
		bw.flush();
		br.close();
		bw.close();
	}
}
