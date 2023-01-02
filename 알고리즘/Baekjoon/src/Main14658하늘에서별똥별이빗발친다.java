import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main14658하늘에서별똥별이빗발친다 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		arr = new int[K][2];

		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());

			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}

		int max = 0;
		// K의 경우의 수를 볼 것
		for (int k = 0; k < K; k++) {
			for (int i = 0; i < K; i++) {
				// k의 x를 기준으로 했을 때
				max = Math.max(max, xCount(arr[k][0]));
				// k의 y를 기준으로 했을 때
				max = Math.max(max, yCount(arr[k][1]));
			}
		}
		System.out.println(max);
	}

	static int N, M, L, K;
	static int[][] arr;

	private static int xCount(int x) {
		int max = 0;
		//범위 설정 i~i+L-1
		for (int i = 0; i <= N - L; i++) {
			int cnt = 0;			
			//k개의 아이중에 범위 안에 들어가는 애들이 몇개인지 보기
			for (int k = 0; k < K; k++) {
				if ((arr[k][0] >= x && arr[k][0] < x+L) && (arr[k][1] < i + L && arr[k][1] >= i)) cnt++;
			}
			max = Math.max(max, cnt);
		}
		return max;
	}
}
