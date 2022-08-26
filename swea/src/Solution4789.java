import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution4789 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		//테스트케이스
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			String str = br.readLine();
			
			//앞의 숫자들의 합과 뒤의 숫자 인덱스 비교
			int sum = 0;
			int ans = 0;
			for (int i = 0; i < str.length()-1; i++) {
				sum+=str.charAt(i)-'0';
				//부족하면 그 만큼 채워줌 -이 채워준 사람 수가 정답
				if (sum < i+1) {
					ans+=i+1-sum;
					sum = sum + (i+1-sum);
				}
			}
			bw.append("#" + tc + " ");
			bw.append(ans + "");
			bw.newLine();
		}
		bw.flush();
		br.close();
		bw.close();
	}
}
