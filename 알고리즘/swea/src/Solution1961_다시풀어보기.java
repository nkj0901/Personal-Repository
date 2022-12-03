import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution1961_다시풀어보기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			int[][] arr90 = new int[N][N];
			int[][] arr180 = new int[N][N];
			int[][] arr270 = new int[N][N];
			
			//90도 회전
			for (int i = N-1; i >= 0; i--) {
				st= new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					arr90[j][i] = Integer.parseInt(st.nextToken()); 
				}
			}
			
			//180도
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					arr180[j][N-i-1] = arr90[i][j];
				}
			}
			
			//270도
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					arr270[j][N-i-1] = arr180[i][j];
				}
			}
			
			bw.write("#" + t + "\n");
			
			//출력
			for (int i = 0; i < N ; i++) {
				
				//90도
				for(int j = 0; j < N; j++) {
					bw.write(arr90[i][j]+"");
				}
				
				bw.write(" ");
				
				
				//180도
				for(int j = 0; j < N; j++) {
					bw.write(arr180[i][j]+"");
				}
				
				bw.write(" ");
				
				//270도
				for(int j = 0; j < N; j++) {
					bw.write(arr270[i][j]+"");
				}
				bw.newLine();
			}
		}
		bw.flush();
		br.close();
		bw.close();
	}
}
