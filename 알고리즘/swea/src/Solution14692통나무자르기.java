import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution14692통나무자르기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			if (Integer.parseInt(br.readLine()) % 2 == 0)
				System.out.println("#" + t + " Alice");
			else
				System.out.println("#" + t + " Bob");
		}
	}
}
