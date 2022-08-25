package swea;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Solution2930_시간초과 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			bw.write("#"+t+" ");
			
			List<Integer> arr = new ArrayList<Integer>();
			int N = Integer.parseInt(br.readLine());
			
			for (int n = 0; n < N; n++) {
				st = new StringTokenizer(br.readLine());
				
				int num = Integer.parseInt(st.nextToken());
				
				// 배열만들기

				if ( num == 1) {
					int tmp = Integer.parseInt(st.nextToken());
					arr.add(tmp);
				} else {
					//배열거꾸로 정렬하면 제일 큰 값을 알 수 있음
					Collections.sort(arr, Collections.reverseOrder());					
					if (arr.size() == 0) bw.write("-1" + " ");
					else {
						bw.write(arr.remove(0) + " ");
					}
				}
			}
			bw.newLine();
		
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
