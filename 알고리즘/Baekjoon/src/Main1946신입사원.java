import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/*
 * 배열의 인덱스를 서류 등수로
 * 해당 인덱스의 값을 면접 등수로 저장
 * 배열돌면서 자신이 앞애 있는 애들 보다 면접 등수가 높은지 보기
 */
public class Main1946신입사원 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[N + 1];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				int idx = Integer.parseInt(st.nextToken());
				arr[idx] = Integer.parseInt(st.nextToken());
			}
			
			//앞에 있는 애들의 취소 면접 순위 (얘보다 낮아야 ans++)
			int min = arr[1];
			int ans = 1; //서류 일등은 뭐 볼 필요도 없다.
			for(int i = 2; i <= N; i++) {
				if(min > arr[i]) { //내가 서류 등수는 졌지만 면접등수는 이겼네?
					min = arr[i];
					ans++;
				}
			}
			System.out.println(ans);
		}
	}
}
