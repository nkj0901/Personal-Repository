import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution1234비밀번호 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		for (int t = 1; t <= 10; t++) {
			bw.write("#" + t + " ");
			st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			List<Character> list = new ArrayList<Character>();
			
			String str = st.nextToken();
			
			//리스트채우기
			for (int i = 0; i < N; i++) {
				list.add(str.charAt(i));
			}
			
			//이전 사이즈 기억해서 이전사이즈와 같으면 종료
			//(사이즈가 같다는 것은 지워질 것 이 없다는 소리)
			int pastSize = N; 
			while(true) {
				for (int i = 0; i < list.size()-1; i++) {
					if (list.get(i) == list.get(i+1)) {
						list.remove(i);
						list.remove(i); //앞에 지워서 i+1였던 것이 i가 된다.
					}
				}
				if (pastSize == list.size()) {
					break;
				}
					pastSize = list.size();
			}
			//리스트 값 출력하기
			for (int i = 0; i < list.size(); i++) {
				bw.write(list.get(i));
			}
			bw.newLine();
		}
		bw.flush();
		br.close();
		bw.close();
	}
}
