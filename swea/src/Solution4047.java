import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;

public class Solution4047 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			Set<Integer> S = new HashSet<>();
			Set<Integer> D = new HashSet<>();
			Set<Integer> H = new HashSet<>();
			Set<Integer> C = new HashSet<>();

			String str = br.readLine();
			
			//문자 세개씩 돌면서 무늬와 숫자를 확인하고
			//각 무늬 set에 해당 숫자가 있는지 확인하고 있으면 에러
			//없으면 넣는다.
			boolean tf = true;
			for (int i = 0; i < str.length()-1; i += 3) {
				int x = str.charAt(i);
				
				//문자열을 숫자로 만들어주기
				int num10 = str.charAt(i+1) - '0';
				int num = str.charAt(i+2) - '0';
				int newNum = (num10 * 10) + num;
				
				if (x == 'S') {
					if (S.contains(newNum)) {
						tf = false;
						break;
					} else {
						S.add(newNum);
					}
				} else if (x == 'D') {
					if (D.contains(newNum)) {
						tf = false;
						break;
					} else {
						D.add(newNum);
					}
				} else if (x == 'H') {
					if (H.contains(newNum)) {
						tf = false;
						break;
					} else {
						H.add(newNum);
					}
				} else if (x == 'C') {
					if (C.contains(newNum)) {
						tf = false;
						break;
					} else {
						C.add(newNum);
					}
				}
			}
			bw.append("#" + tc + " ");
			if (tf == true) {
				bw.append(13-S.size()+" ");
				bw.append(13-D.size()+" ");
				bw.append(13-H.size()+" ");
				bw.append(13-C.size()+"");
			} else {
				bw.append("ERROR");
			}
			bw.newLine();
		}
		bw.flush();
		br.close();
		bw.close();
	}
}
