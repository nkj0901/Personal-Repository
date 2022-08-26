import java.util.Base64;
import java.util.Scanner;

public class Solution1928 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int tc = sc.nextInt();

		for (int t = 0; t < tc; t++) {
			String string = sc.next();
			String s = new String(Base64.getDecoder().decode(string));
			
			System.out.printf("#%d %s\n", t, s);
		}
		sc.close();
	}
}
