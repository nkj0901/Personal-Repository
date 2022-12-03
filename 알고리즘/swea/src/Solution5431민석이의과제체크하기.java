import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution5431민석이의과제체크하기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			boolean[] check = new boolean[N+1];
			int K = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < K; i++) {
				int person = Integer.parseInt(st.nextToken());
				check[person] = true;
			}
			
			System.out.print("#" + t + " ");
			for(int i = 1; i <= N; i++) {
				if(check[i] == false) {
					System.out.print(i + " ");
				}
			}
			System.out.println();
		}
	}
}
