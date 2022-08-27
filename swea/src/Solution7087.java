import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution7087 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			//char A-Z 문자를 int로 표현하면 65~90
			int[] arr= new int[91];
			
			for (int i = 0; i < N ; i++) {
				String str = br.readLine();
				arr[str.charAt(0)]++;
			}
			
			//카운팅 배열에 A부터 어디까지 1이 있는지 확인
			int cnt = 0;
			for (int i = 65; i <=90; i++) {
				if (arr[i] == 0) {
					break;
				}
				cnt++;
			}
			bw.append("#" + t + " " + cnt+"\n");
		}//테케
		bw.flush();
		br.close();
		bw.close();
	}//메인
}
