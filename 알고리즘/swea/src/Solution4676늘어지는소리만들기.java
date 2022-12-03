import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution4676늘어지는소리만들기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			String str = br.readLine(); //입력
			
			int l = str.length(); // 문자열 길이
			char[] charArr = str.toCharArray();
			int[] cnt = new int[l+1];
			
			int N = Integer.parseInt(br.readLine()); //넣을 하이픈 개수
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				cnt[Integer.parseInt(st.nextToken())]++;
			}
			
			bw.append("#" + t + " ");
			for(int i = 0; i <= l; i++) {
				for(int j = 0; j < cnt[i]; j++) {
					bw.append("-");
				}
				if (i == l) break;
				bw.append(charArr[i]);
			}
			bw.newLine();
		}
		bw.flush();
		br.close();
		bw.close();
	}
}
