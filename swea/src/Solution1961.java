import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution1961 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for ( int tc = 1; tc <= T; tc++) {
			bw.append("#"+tc);
			bw.newLine();
			int N = Integer.parseInt(br.readLine());
			
			//N*N만큼의 배열을 만들기
			int[][] arr = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j<N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					
				}
			}
			
			//arr90도 만들기
			int[][] arr90 = new int[N][N];
			int last = N;
			for (int i =0 ; i < N ; i++) {
				last--;
				for (int j = 0; j < N; j++)
				arr90[j][last]=arr[i][j];
			}
			
			//arr180도 만들기
			int[][] arr180 = new int[N][N];
			last = N;
			for (int i =0 ; i < N ; i++) {
				last--;
				for (int j = 0; j < N; j++)
				arr180[last][arr.length-1-j]=arr[i][j];
			}
			
			int[][] arr270 = new int[N][N];
			for (int i =0 ; i < N ; i++) {
				for (int j = 0; j < N; j++)
				arr270[arr.length-1-j][i]=arr[i][j];
			}
			
			//출력
			for (int i = 0; i < N; i++) {
				for (int j =0; j < N; j++) {
					bw.append(arr90[i][j]+"");
				}
				bw.append(" ");
				
				for (int j =0; j < N; j++) {
					bw.append(arr180[i][j]+"");
				}
				bw.append(" ");
				
				for (int j =0; j < N; j++) {
					bw.append(arr270[i][j]+"");
				}
				bw.newLine();
			}
		}
		bw.flush();
		br.close();
		bw.close();
	}
}
