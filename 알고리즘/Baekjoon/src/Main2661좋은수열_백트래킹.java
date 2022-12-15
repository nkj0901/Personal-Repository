import java.util.Arrays;
import java.util.Scanner;

public class Main2661좋은수열_백트래킹 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		sel = new int[N];
		ans = "";

		// 조합시작
		combi("");
	}

	static int N;
	static String ans;
	static int[] sel;

	private static void combi(String result) {

		if (result.length() == N) {
			System.out.println(result);
			// 1부터 넣었기 때문에 처음 나오는 값이 최소값
			System.exit(0);
		}
		//문자 + 숫자일 때 문자가 됨
		for (int i = 1; i <= 3; i++) {
			if (goodSequence(result + i)) {
				combi(result + i);
			}
		}
	}

	private static boolean goodSequence(String s) {
		int length = s.length()/2;
		for (int i = 1; i <= length; i++) {
			//substring beginIndex위치에서 시작하여 endIndex 전 위치까지의 값을 리턴
			if(s.substring(s.length()-i).equals(s.substring(s.length()-2*i, s.length()-i))) {
				return false;
			}
		}
		return true;
	}

}
