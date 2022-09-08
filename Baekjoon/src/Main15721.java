import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main15721 {
	static int N;
	static int A;
	static int T;
	static int bbun;
	static int daegi;
	static int seq;
	static int ans;

	public static boolean func() {

		// 뻔 N번이 조건일 때
		if (N == 0 && bbun == T) {
			ans = (seq - 1) % A;
			return true;
		}
		// 데기 N번이 조건일 때
		else if (N == 1 && daegi == T) {
			ans = (seq - 1) % A;
			return true;
		}
		return false;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		A = Integer.parseInt(br.readLine()); // 사람수
		T = Integer.parseInt(br.readLine()); // 몇번째?
		N = Integer.parseInt(br.readLine()); // 0이면 뻔, 1이면 데기
		ans = 0;
		bbun = 0; // 뻔이 나온 횟수
		daegi = 0; // 데기가 나온 횟수
		seq = 0; // 누가 말할 차례
		int turn = 2; // 뻔데기 회전 수(뻔과 데기를 몇번 외쳐야 하는지)

		loop: while (true) {
			for (int i = 0; i < 2; i++) {
				bbun++;
				seq++;
				if (func() == true)
					break loop;
				daegi++;
				seq++;
				if (func() == true)
					break loop;
			}

			for (int i = 0; i < turn; i++) {
				bbun++;
				seq++;
				if (func() == true)
					break loop;
			}

			for (int i = 0; i < turn; i++) {
				daegi++;
				seq++;
				if (func() == true)
					break loop;
			}
			turn++;
		}
		bw.write(ans + "");
		bw.flush();
		br.close();
		bw.close();
	}
}
