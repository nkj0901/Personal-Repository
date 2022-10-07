import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution10912외로운문자 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			String str = br.readLine();
			int l = str.length();

			char[] c = str.toCharArray();
			for (int i = 0; i < l - 1; i++) {
				for (int j = i + 1; j < l; j++) {
					// 같으면 기본값으로 바꿔준다.
					if (c[i] == c[j]) {
						c[i] = '\u0000';
						c[j] = '\u0000';
					}
				}
			}

			Arrays.sort(c);
			boolean flag = false;
			// 남은 글자가 있는지 본다.
			for (int i = 0; i < l; i++) {
				if (c[i] != '\u0000')
					flag = true;
			}
			
			System.out.print("#" + t + " ");
			if (flag == false)
				System.out.print("Good");
			else {
				for (int i = 0; i < l; i++) {
					if (c[i] != '\u0000') {
						System.out.print(c[i]);
					}
				}
			}
			System.out.println();

		}
	}
}
