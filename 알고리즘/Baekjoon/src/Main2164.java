import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2164 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 카드의 개수
		int N = Integer.parseInt(br.readLine());
		int front = -1;
		int rear = -1;
		int size = 0;

		// 1~N을 가진 배열을 만든다.
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			if (size == 0) {
				arr[i] = i + 1;
				front = i;

			} else {
				arr[i] = i + 1;
			}
			size++;
			rear = i;
		}

		// 큐를 이용하여 front지우고 짝수번째에는 front를 지우고 다시 뒤에 삽입한다.
		int n = 1; // 짝수번째에는 rear뒤에 수를 넣을 것.
		while (size != 1) {
			if (n % 2 != 0) {// 홀수라면
				front = (front + 1) % N;
				size--;
			} else {// 짝수라면
				// front 값을 rear에 넣기
				arr[(rear + 1) % N] = arr[front];
				front = (front + 1) % N;
				rear = rear + 1 % N;
			}
			n++;
		}
		System.out.println(arr[front]);
		br.close();
	}
}
