import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution2805 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		//테스트케이스
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			
			//경작지 넓이
			int N = Integer.parseInt(br.readLine());
			int[][] arr = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				String str = br.readLine();
				for (int j = 0; j < N; j++) {
					arr[i][j]=str.charAt(j)-'0';
				}
			}
			
			int first = N/2;
			int last = N/2;
			int sum = 0;
			for (int i = 0; i < N; i++) {
				for (int j = first; j <= last; j++) {
					sum+=arr[i][j];
				}
				if (i >= N/2) {
					first++; last--;
				} else {
					first--; last++;
				}
			}
			
			bw.append("#" + tc + " " + sum);
			bw.newLine();
		}
		bw.flush();
		br.close();
		bw.close();
	}
}
