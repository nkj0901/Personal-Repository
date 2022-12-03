import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main1205등수구하기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int taesu = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());

		int ans = 1;

		if (N != 0) {

			List<Integer> list = new ArrayList<Integer>();
			list.add(taesu);

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				list.add(Integer.parseInt(st.nextToken()));
			}

			Collections.sort(list, Collections.reverseOrder());

			int cnt = 0;
			int max = Integer.MAX_VALUE;
			for (int i = 0; i < list.size(); i++) {
				// 숫자가 바귈 때마다 체크
				if(max > list.get(i)) {
					if(list.get(i) == taesu) {
						ans = i+1;
						
						for(int j = i+1; j < list.size(); j++) {
							if(taesu!=list.get(j)) {
								break;
							}
							cnt++;
						}
						ans = ans+cnt > P ? -1 : ans;
					}
					max = list.get(i);
				}
			}
		}
		System.out.println(ans);
	}
}
