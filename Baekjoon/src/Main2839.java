import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main2839 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int five = 0;
		int three = 0;

		while (N / 3 > 0) {
			if (N % 5 == 0)
				break;
			three++;
			N = N - 3;
		}

		while (N / 5 > 0) {
			five++;
			N = N - 5;
		}
		if (N == 0) {
			System.out.println(three + five);
		} else {
			System.out.println("-1");
		}
	}
}
