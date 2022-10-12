import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution10761신뢰 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());

			char[] c = new char[N]; // 누가 누르는가
			int[] n = new int[N]; // 뭘 누르는가

			for (int i = 0; i < N; i++) {
				String tmp = st.nextToken();
				c[i] = tmp.charAt(0);
				n[i] = Integer.parseInt(st.nextToken());
			}

			// 현재 위치
			int O = 1;
			int B = 1;
			int ans = 0; // 걸린시간
			int time;

			for (int i = 0; i < N; i++) {
				char tmp = c[i];

				if (tmp == 'O') {
					time = Math.abs(O - n[i]) + 1;
					O = n[i];
					ans += time; // 가서 누르는 것까지의 시간을 더해준다.

					for (int j = i + 1; j < N; j++) {
						if (c[j] == 'B') {
							if (Math.abs(B - n[j]) < time) { // 현재 지나간 시간보다 B가 가는데 필요한 시간이 적을 때
								B = n[j];
							} else { // 현재 지나간 시간보다 B가 가는데 필요한 시간이 더 길면...

								if (B - n[j] > 0) //가야하는 곳이 뒤에 있을 때
									B -= time;
								else //가야하는 곳이 앞에 있을 때
									B += time;
							}
							break;
						}
					}
				} else {
					time = Math.abs(B - n[i]) + 1;
					B = n[i];
					ans += time; // 가서 누르는 것까지의 시간을 더해준다.

					for (int j = i + 1; j < N; j++) {
						if (c[j] == 'O') {
							if (Math.abs(O - n[j]) < time) { // 현재 지나간 시간보다 O가 가는데 필요한 시간이 적을 때
								O = n[j];
							} else { // 현재 지나간 시간보다 O가 가는데 필요한 시간이 더 길면...
								if (O - n[j] > 0) //가야하는 곳이 뒤에 있을 때
									O -= time;
								else //가야하는 곳이 앞에 있을 때
									O += time;
							}
							break;
						}
					}
				}
			}
			System.out.println("#" + t + " " + ans);
		} // tc
	}
}
