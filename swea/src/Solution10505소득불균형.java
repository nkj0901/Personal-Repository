import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution10505소득불균형 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[N];
			
			//배열채우면서 총합 구해주기
			int sum = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
				sum+=arr[i];
			}
			//평균구하기
			float avg = sum/N;
			
			//평균이하 카운트
			int cnt = 0;
			for (int i = 0; i < N; i++) {
				if (arr[i] <= avg) cnt++;
			}
			bw.write("#"+ t + " " + cnt +"\n");
		} //tc
		bw.flush();
		br.close();
		bw.close();
	}
}
