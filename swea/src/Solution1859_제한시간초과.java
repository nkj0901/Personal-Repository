import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution1859_제한시간초과 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		// 테스트케이스
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {

			// 일수
			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[N];

			// 일별 가격받기
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			// 내 뒤에 제일 큰수가 있으면 오늘 사서 제일 비싼 날에 팔기 
			// 내가 제일 크면 안사고 안팔아
			int ans = 0;
			for (int i = 0; i < arr.length - 1; i++) {
				boolean big = false; //뒤에 더 큰 값이 있는지 체크
				int max = arr[i]; //제일 바싼 값 저장
				int index = 0;
				for (int j = i + 1; j < arr.length; j++) {
					if (max < arr[j]) {
						big = true; //뒤에 더 큰 값이 있으면 true로 바꿔주고
						max = arr[j];//제일 큰 값이 무엇인지 저장
					}
				}
				//더 큰값이 있다고 하면
				if (big == true) {
					ans+= max - arr[i]; //차익 계산
				}
			}
			// 일수별 가격
			bw.append("#" + tc + " " + ans);
			bw.newLine();
		}
		bw.flush();
		br.close();
		bw.close();
	}
}
