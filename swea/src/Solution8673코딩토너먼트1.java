import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution8673코딩토너먼트1 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			int n = Integer.parseInt(br.readLine());
			
			//2의 n 제곱만큼의 리스트 만들기
			int npow = (int) Math.pow(2,n);
			List<Integer> list = new ArrayList<>();
			
			//리스트에 숫자 채우기
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < npow; i++) {
				list.add(Integer.parseInt(st.nextToken()));
			}
			
			//list size가 1일 될때까지 두개비교
			int ans = 0;
			while(list.size()!=1) {
				//앞에서부터 두개 비교하면서 더 작은 걸 삭제
				for (int i = 0; i < list.size(); i++) {
					ans+=Math.abs(list.get(i)-list.get(i+1));
					if (list.get(i)>list.get(i+1)){
						list.remove(i+1);
					} else {
						list.remove(i);
					}
				}
			}
			bw.write("#" + t + " " + ans + "\n");
		}
		bw.flush();
		br.close();
		bw.close();
	}
}
