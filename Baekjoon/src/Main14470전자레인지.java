import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main14470전자레인지 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int cur = Integer.parseInt(br.readLine()); // 현재온도
		int des = Integer.parseInt(br.readLine()); // 목표온도
		int C = Integer.parseInt(br.readLine()); // 얼어있을 때 1도 올리는데 걸리는 시간
		int D = Integer.parseInt(br.readLine()); // 0도에서 해동하는데 걸리는 시간
		int E = Integer.parseInt(br.readLine()); // 얼어있지 않을 때 1도 올리는데 걸리는 시간

		int time = 0;
		while (cur != des) {
			// 얼어있지 않은 상태라면
			if (cur > 0) {
				time += E;
				cur++;
			} else if (cur < 0) {
				time += C;
				cur++;
			} else if (cur == 0) {
				time += D;
				time += E;
				cur++;
			}
		}
		System.out.println(time);
	}
}
