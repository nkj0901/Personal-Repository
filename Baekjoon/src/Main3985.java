import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main3985 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// 케이크의 길이만큼 배열만들기
		int L = Integer.parseInt(br.readLine());
		int[] arr = new int[L];

		// 케이크를 받을 사람의 인원수
		int N = Integer.parseInt(br.readLine());

		// 3명이 각각 원하는 케이크의 번호를 받는다.
		int max = 0; // 케이크를 가장 많이 받을 것으로 예상되는 사람
		int index = 0;
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			// 가장많은 조각을 받을 것으로 기대하는 사람은 p와 k의 차이가 큰 사람
			// 수가 같으면 더 작은 번호의 사람을 출력
			if (b - a > max) {
				max = b - a;
				index = i;
			}

			// 실제로 가장 많은 조각을 받은 사람 배열에 숫자가 제일 많은 사람
			for (int j = a-1; j <= b-1; j++) {
				// 비어있을 때만 숫자를 넣어라
				if (arr[j] == 0)
					arr[j] = i;
			}
		}
		bw.write(index + "");
		bw.newLine();
		// 배열에 뭐가 제일 많이 있는지 찾아보자
		int person = 0;
		int max1 = 0;
		for (int n = 1; n <= N; n++) {
			int cnt = 0;
			for (int i = 0; i < L; i++) {
				if (arr[i] == n) {
					cnt++;
				}
			}
			if (cnt > max1) {
				max1 = cnt;
				person = n;
			}
		}
		bw.write(person+"");
		bw.flush();
		br.close();
		bw.close();
	}
}
