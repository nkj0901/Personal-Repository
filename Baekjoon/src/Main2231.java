import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main2231 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int M = N;
		int ans = 0;
		
		for (int i = 1; i < N; i++) {
			M=N-i;
			int tmpAns = M;
			
			int tmpM = M; //자리수 구하기 위해 임시 저장
			while (tmpM > 0) {
				M+=tmpM%10;
				tmpM/=10;
			}
			if (M == N) {
				ans = tmpAns;
			}
		}
		bw.write(ans +"");
		bw.flush();
		br.close();
		bw.close();
	}
}
