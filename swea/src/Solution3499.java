import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution3499 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		// 테스트케이스
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			bw.append("#" + tc + " ");
			// 단어 개수
			int N = Integer.parseInt(br.readLine());
			String[] arr1 = new String[N]; // 앞에 절반 담을 배열
			String[] arr2 = new String[N]; // 뒤에 절반 담을 배열

			// 몇번 index 전까지 arr1에 저장할 것인지
			int x = 0;
			if (N % 2 == 0)
				x = N / 2;
			else
				x = N / 2 + 1;
			
			//반 나눠서 x 전까지 저장
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < x; i++) {
				arr1[i] = st.nextToken();
			}
			// 뒤에 반 arr2에 저장
			for (int i = 0; i < N/2; i++) {
				arr2[i] = st.nextToken();
			}

			for (int i = 0; i < x; i++) {
				if (arr1[i] != null)
					bw.append(arr1[i]);
				bw.append(" ");
				if (arr2[i] != null)
					bw.append(arr2[i]);
				bw.append(" ");
			}
			bw.newLine();
		}
		bw.flush();
		br.close();
		bw.close();
	}
}
