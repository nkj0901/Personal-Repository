import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main2422한윤정의이탈리아가게아이스크림 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[M][2];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		
		
		int cnt = 0;
		int ans = 0;
		//모든 경우의 수를 보기
		for (int i = 0; i < (1<<N); i++) {
			cnt = 0;
			for (int j = 0; j < N; j++) {
				if ((i & (1<<j)) > 0) {
					cnt++;
					if (cnt > 3) break;
				}
			}
			
			if (cnt == 3) {
				boolean check = true;
				for (int j = 0; j < M; j++) {
					if((i & (1<<arr[j][0]-1)) > 0 && (i & (1<<arr[j][1]-1)) > 0) {
						check = false;
					}
				}
				if (check == true) ans++;
			}
		}
		bw.write(ans + " ");
		bw.flush();
		br.close();
		bw.close();
	}
}
