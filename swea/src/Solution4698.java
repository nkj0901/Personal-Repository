import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution4698 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		boolean[] arr = new boolean[1000001];
		arr[0] = true;
		arr[1] = true;

		// 아라토스테네스의 체 방식
		for (int i = 2; i < arr.length; i++) {
			if (!arr[i]) {
				int j = 2;
				while (true) {
					if (i * j > 1000000)
						break;
					arr[i * j] = true;
					j++;
				}
			}
		}

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());

			String D = st.nextToken();
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			if (A == 1) {
				A = 2;
			}

			int cnt = 0;
			for (int i = A; i <= B; i++) {
				if(arr[i] == false) {
					String str = String.valueOf(i);
					if (str.contains(D) && arr[i] == false) {
						cnt++;
					}
					
				}
			}
			sb.append("#" + tc + " " + cnt + "\n");
		}
		br.close();
		System.out.println(sb);
	}
}