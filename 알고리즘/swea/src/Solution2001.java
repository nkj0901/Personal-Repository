import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution2001 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		//테스트케이스
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()); //배열 크기
			int M = Integer.parseInt(st.nextToken()); //파리채 크기
			
			//배열만들기
			int[][] arr = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			//배열 중 가장 큰 탐색 - 마지막 M-1개씩는 안 돌려도 됨
			int max = 0; // 제일 합이 큰 부분
			for (int i = 0; i <= N-M; i++) {
				for (int j = 0; j <= N-M; j++) {
					//파리채만큼 탐색
					int sum = 0;
					for (int x = 0; x < M; x++) {
						for (int y = 0; y < M; y++) {
							sum+=arr[i+x][j+y];
						}
						if (sum > max) {
							max = sum;
						}
					}
				}
			}
			bw.append("#" + tc + " " + max);
			bw.newLine();
		}
		bw.flush();
		br.close();
		bw.close();
	}
}
