import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main2503 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());

		int[][] arr = new int[N][3];
		int[][] ans = new int[N][2];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			arr[i][0] = str.charAt(0) - '0';
			arr[i][1] = str.charAt(1) - '0';
			arr[i][2] = str.charAt(2) - '0';
			ans[i][0] = Integer.parseInt(st.nextToken());
			ans[i][1] = Integer.parseInt(st.nextToken());
		}
		int num = 123; // 세자리 숫자중에 제일 작은 수
		int A =0;
		//숫자 하나씩 늘려가면서 볼거야
		while (num <=987) {
			int cnt = 0;
			int strike = 0;
			int ball = 0;
			String str = num + ""; //숫자 문자열로 만들어줘~
			
			//이 숫자가 주어진 숫자들과 비교했을 때, 스타라이크와 볼이 몇개인지 확인
			//주어진 답과 수가 일치하면 정답 후보가 됨(cnt++)
			for (int i = 0; i < 4; i++) {
				
					if (arr[i][0] == str.charAt(0)) {
						strike++;
					} else if (arr[i][0] == str.charAt(1)) {
						ball++;
					} else if (arr[i][0] == str.charAt(2)) {
						ball++;
					}	
					
					if (arr[i][1] == str.charAt(0)) {
						ball++;
					} else if (arr[i][1] == str.charAt(1)) {
						strike++;
					} else if (arr[i][1] == str.charAt(2)) {
						ball++;
					}
					
					if (arr[i][2] == str.charAt(0)) {
						ball++;
					} else if (arr[i][2] == str.charAt(1)) {
						ball++;
					} else if (arr[i][2] == str.charAt(2)) {
						strike++;
					}
					if (ans[i][0] == strike || ans[i][1] == ball) {
						cnt++;
					}
			}
			if (cnt == 4) {
				A++;
			}
			System.out.println(num);
			num++;
		}
		bw.write(A+"");
		bw.flush();
		br.close();
		bw.close();

	}
}
