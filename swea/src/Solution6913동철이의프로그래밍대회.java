import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution6913동철이의프로그래밍대회 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int[] arr = new int[N];//각각 몇개 맞췄는지 저장
			int max = 0; // 일등 몇개맞았어?
			
			//각 사람마다 몇개 맞았는지
			for (int i = 0; i <N; i++) {
				int cnt = 0;
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					if (Integer.parseInt(st.nextToken()) == 1) {
						cnt++;
					}
				}
				if (cnt > max) { //최고 많이 맞은 사람 찾기
					max = cnt;
				}
				arr[i] = cnt; //배열에 몇개 맞았는지 저장
			}
			
			//max만큼 맞은 사람 총 몇명???
			int ans = 0;
			for (int i = 0 ; i < N; i++ ) {
					if (arr[i] == max) {
						ans++;
				}
			}
			bw.write("#" + t + " " + ans + " " + max + "\n");
		}
		bw.flush();
		br.close();
		bw.close();
	}
}
