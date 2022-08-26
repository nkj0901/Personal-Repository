import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution4698 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		boolean[] arr = new boolean[1000001];
		
		for (int i = 2; i*2 <= 1000000; i++) {
			//i의 배수들을 다 false로 바꿈
			arr[i*2]=false;
		}

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());

			String D = st.nextToken();
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			
			
			bw.append("#" + tc + " ");
			bw.append(+ "");
			bw.newLine();
		}
		bw.flush();
		br.close();
		bw.close();
	}
}
