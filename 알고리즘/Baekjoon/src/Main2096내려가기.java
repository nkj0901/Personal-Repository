import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2096내려가기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[][] minArr = new int[N][3];
		int[][] maxArr = new int[N][3];
		
		st = new StringTokenizer(br.readLine());
		minArr[0][0] = Integer.parseInt(st.nextToken());
		minArr[0][1] = Integer.parseInt(st.nextToken());
		minArr[0][2] = Integer.parseInt(st.nextToken());
		
		maxArr[0][0] = minArr[0][0];
		maxArr[0][1] = minArr[0][1];
		maxArr[0][2] = minArr[0][2];
		
		for(int i = 1; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			minArr[i][0] = Math.min(minArr[i-1][0], minArr[i-1][1]) + a;
			minArr[i][1] = Math.min(Math.min(minArr[i-1][0], minArr[i-1][1]), minArr[i-1][2]) + b;
			minArr[i][2] = Math.min(minArr[i-1][1], minArr[i-1][2]) + c;
		
			maxArr[i][0] = Math.max(maxArr[i-1][0], maxArr[i-1][1]) + a;
			maxArr[i][1] = Math.max(Math.max(maxArr[i-1][0], maxArr[i-1][1]), maxArr[i-1][2]) + b;
			maxArr[i][2] = Math.max(maxArr[i-1][1], maxArr[i-1][2]) + c;
		}
		
		int min = Math.min(Math.min(minArr[N-1][0], minArr[N-1][1]), minArr[N-1][2]);
		int max = Math.max(Math.max(maxArr[N-1][0], maxArr[N-1][1]), maxArr[N-1][2]);
				
		System.out.println(max + " " + min);
	}
}
