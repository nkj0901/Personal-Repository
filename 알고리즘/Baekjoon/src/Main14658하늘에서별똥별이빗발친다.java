import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main14658하늘에서별똥별이빗발친다 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		arr = new int[K][2];

		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());

			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		
		max = 0;
		// k를  x로
		for(int k = 0; k < K; k++) {
			//i를 y로
			for(int i = 0; i < K; i++) {
				cnt = 0;
				count(arr[k][0], arr[i][1]);
			}
		}
		System.out.println(K-max);
	}
	
	static int cnt, max, L, K;
	static int[][] arr;

	private static void count(int x, int y) {
		for(int i = 0; i < K; i++) {
			//모서리에 닿아도 튕겨져 나가므로 x+L까지의 경우를 보아야 한다.
			if(arr[i][0] >= x && arr[i][0] <= x+L && arr[i][1] >= y && arr[i][1] <= y+L) cnt++;
		}
		max = Math.max(max, cnt);
	}

}
