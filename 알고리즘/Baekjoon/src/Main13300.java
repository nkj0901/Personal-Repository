import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main13300 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] W = new int[7];//여학생 배열
		int[] M = new int[7];//남학생 배열
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int S = Integer.parseInt(st.nextToken());
			int Y = Integer.parseInt(st.nextToken());
			
			if (S == 0) {
				W[Y]++;
			} else {
				M[Y]++;
			}
		}
		//여자방 수
		int Wsum = 0;
		for (int i = 1; i < W.length; i++) {
			Wsum+=W[i]/K;
			if(W[i]%K!=0) {
				Wsum++;
			}
		}
		//남자방 수
		int Msum = 0;
		for (int i = 1; i < M.length; i++) {
			Msum+=M[i]/K;
			if(M[i]%K!=0) {
				Msum++;
			}
		}
		bw.write(Wsum+Msum+"");
		bw.flush();
		br.close();
		bw.close();
	}
}
