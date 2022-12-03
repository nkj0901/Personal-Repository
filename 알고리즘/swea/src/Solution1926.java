import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution1926 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		//숫자 입력
		int N = Integer.parseInt(br.readLine());
		
		//1~N까지의 수중에 369찾아서 -으로 바꾸기
		for (int i = 1; i <= N; i++) {
			//숫자를 문자열로 바꾸기
			String str = String.valueOf(i);
			for (int j = 0; j < str.length(); j++) {
				//369이면 - 출력 아니면 숫자 출력
				if (str.charAt(j) == '3' || str.charAt(j) == '6' || str.charAt(j) == '9') 
					bw.append("-");
				else {
					if (! str.contains("3") && ! str.contains("6") && ! str.contains("9")) {
						bw.append(str.charAt(j)+"");
					}
				}
			}
			if (i != N)
			bw.append(" ");
		}
		bw.flush();
		br.close();
		bw.close();
	}
}
