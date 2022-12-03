import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main19532 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		int f = Integer.parseInt(st.nextToken());
		
		//정답
		int ans1 = 0; int ans2 = 0;
		for (int i = -999; i < 1000; i++) {
			for (int j = -999; j < 1000; j++) {
				if ((a*i)+(b*j)== c && (d*i)+(e*j) == f) {
					ans1 = i; ans2 = j;
					break;
				}
			}
		}
		bw.write(ans1 + " " + ans2);
		bw.flush();
		br.close();
		bw.close();
	}
}
