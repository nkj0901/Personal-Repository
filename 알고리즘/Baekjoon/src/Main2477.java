import java.io.IOException;
import java.util.Scanner;

import javax.swing.plaf.synth.SynthSeparatorUI;

public class Main2477 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);

		// 1제곱당 열리는 참외 개수
		int K = sc.nextInt();
		int[] dir = new int[6];
		int[] s = new int[6];

		int wmax = 0;
		int hmax = 0;
		int windex = 0;
		int hindex = 0;
		// 방향과 길이를 받고 배열에 넣는다. 큰 사각형을 구할 가로 세로 크기를 구한다.
		for (int i = 0; i < 6; i++) {

			int direction = sc.nextInt();
			int side = sc.nextInt();

			dir[i] = direction;
			s[i] = side;

			if (direction == 3 || direction == 4) {
				if (wmax < side) {
					wmax = side;
					windex = i;
				}
			} else if (direction == 1 || direction == 2) {
				if (hmax < side) {
					hmax = side;
					hindex = i;
				}
			}
		}
		// 0이나 6이 넘어가지 않도록 인덱스 조절
		// 가장 긴변(가로, 세로 각각) 양옆 값을 빼면 작은 사각형의 변 길이가 나옴
		int wmin = Math.abs(s[(windex +5) % 6] - s[(windex + 1) % 6]);
		int hmin = Math.abs(s[(hindex +5) % 6] - s[(hindex + 1) % 6]);
		
		int bigsquare = wmax * hmax;
		int smallsquare = wmin * hmin;
		int extend = bigsquare - smallsquare;

		System.out.println(extend * K);
	}
}
