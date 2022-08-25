import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Solution1231_x {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for (int T = 1; T <= 10; T++) {
			int N = Integer.parseInt(br.readLine()); // 단어길이

			String[] ap = new String[N + 1]; // 알파벳 닮을 배열
			int[] left = new int[N + 1]; // 왼쪽 인덱스를 닮을 배열
			int[] right = new int[N + 1]; // 오른쪽 인덱스를 닮을 배열

			// 배열채우기
			for (int n = 0; n < N; n++) {
				String str = br.readLine();
				int index = Integer.parseInt(str.split(" ")[0]);
				ap[index] = str.split(" ")[1];
			}
			// 왼쪽 오른쪽 인덱스 채우기
			for (int n = 1; n <= N / 2 - 1; n++) {
				left[n] = n * 2;
				right[n] = n * 2 + 1;
			}
			// 단어길이가 짝수면 하나 더 채워야 함
			if (N % 2 == 0) {
				left[N / 2] = N / 2 * 2;
			}

			// 알파벳을 담을 스택 만들기
			Stack<String> stack = new Stack<>();
			int size = 0;
			// 인덱스 1부터 순회시작
			int tmp = 1;
			stack.add(ap[tmp]);
			size++;
			bw.write("#" + T + " ");
			while (size != 0) {

				// 왼쪽과 오른쪽이 다 비어있으면 스텍에서 제거
				if (left[tmp] == 0 && right[tmp] == 0) {
					bw.write(stack.pop() + "");
					size--;
					if (stack.size() != 0 && stack.peek() == (ap[tmp/2])) {
					tmp = (tmp / 2);
					} else {
						tmp = tmp /2/2;
					}
				} 
				else if (left[tmp] == 0) {
					// 왼쪽만 비어있으면 일단 v를 지우고
					bw.write(stack.pop() + "");
					size--;
					// 오른쪽 본다.
					int x = right[tmp];
					right[tmp] = 0; // 비어있음을 0으로 표시
					tmp = x;
					size++;
					stack.add(ap[tmp]);
				}
				// 돌다 있으면 왼쪽을 봐
				else {
					int x = left[tmp];
					left[tmp] = 0; // 비어있음을 0으로 표시
					tmp = x;
					stack.add(ap[tmp]);
					size++;
				}
			}
			bw.newLine();
		}
		bw.flush();
		br.close();
		bw.close();
	}
}
