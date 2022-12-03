import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main8320 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());

		// 1줄부터 n줄로 나열할 경우
		int cnt = 0;
		for (int i = 1; i <= N; i++) {
			for (int j = i; i*j <= N; j++) {
					cnt++;
			}
		}

		bw.write(cnt + "");
		bw.flush();
		br.close();
		bw.close();
	}
}

		/*
		ex) 20
		i*j 가 N을 넘지 않으면 만들 수 있는 것.
		1줄(i)로
		1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20
		2줄(i)로
		이전 모양은 겹치니 2(j)부터 찾기
		2 3 4 6 7 8 9 10
		3줄(i)로
		이전 모양은 겹치니 3(j)부터 찾기
		3 4 5 6
		4줄(i)로
		- 4(j)부터 찾기
		4 5
		5(i)줄로
		5(j)부터 찾기
		없음
		없으면 멈춘다.
		*/

// 회전 수 줄이려고 넣었는데 이거 넣으니까 틀리더라.....
//		int n = 0; //몇줄로 세울 수 있는 지 확인
//		for (int i = 1; i < N; i++) {
//			if (i*i >= N) {
//				n = i-1;
//				break;
//			}
//		}