import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution7964 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());// 도시수
			int D = Integer.parseInt(st.nextToken());// 이동가능거리

			// 배열채우기
			int[] arr = new int[N + 2];
			arr[0] = 1;
			arr[N + 1] = 1;

			st = new StringTokenizer(br.readLine());
			for (int n = 1; n <= N; n++) {
				arr[n] = Integer.parseInt(st.nextToken());
			}

			// 필요한 문 개수 구하기 - 0부터 N+1까지 이동해보기
			int cnt = 0;
			for (int i = 0; i < N + 1;) { // i를 현재 위치라고 생각. 아래에서 i조정해줄거라 증감은 생략~
				// D범위 내에 1이 있는지 보고 1이 있으면 거기로 이동
				// 빨리 가는 게 목적이 아니고 최소한의 관문을 만드는게 목적이므로 굳이 D칸이 움직일 필요는 없음
				for (int d = 1; d <= D; d++) {
					if (i + d <= N + 1 && arr[i + d] == 1) {
						i = i + d;
						break;
					} else if (d == D) {
						cnt++; // 거리내에 1이 없었다면 cnt++
						i = i + d; // d칸 지나서 차원관문 설치할거니깐 i = i+d
					}
				}
			}
			bw.append("#" + t + " " + cnt + "\n");
		} // 테케
		bw.flush();
		br.close();
		bw.close();
	}// 메인
}
