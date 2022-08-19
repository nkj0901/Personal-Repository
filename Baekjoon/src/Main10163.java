import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main10163 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		//색종이 개수 받기
		int T = Integer.parseInt(br.readLine());
		
		//배열 만들기
		int[][] arr = new int[1001][1001];
		
		//색종이 개수 만큼 위치 받기
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int start = Integer.parseInt(st.nextToken());
			int start1 = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			
			for (int i = start; i < w; i++) {
				for (int j = start1; j < h; h++) {
					arr[i][j] = 0;
				}
			}
			
			for (int i = start; i < w; i++) {
				for (int j = start1; j < h; h++) {
					arr[i][j] = t;
				}
			}
			
			for (int i = 0; i < 1001; i++) {
				for (int j = 0; j < 1001; h++) {
					
				}
			}
		}
	}
}
