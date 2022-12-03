import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution9489고대유적 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int[][] arr = new int[N][M];
			
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < M; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int ans = 0;
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					if(arr[i][j] == 1) {
						int h = 1;
						int v = 1;
						int idx = 1;
						
						//가로
						while(true) {
							if(j+idx < M && arr[i][j+idx] == 1) {
							h++;	
							} else {
								break;
							}
							idx++;
						}
						
						idx = 1;
						
						//세로
						while(true) {
							if(i+idx < N && arr[i+idx][j] == 1) {
							v++;	
							} else {
								break;
							}
							idx++;
						}
						
						ans = Math.max(Math.max(ans, v),h);
					}
				}
			}
			System.out.println("#" + t + " " + ans);
		}
	}
}
