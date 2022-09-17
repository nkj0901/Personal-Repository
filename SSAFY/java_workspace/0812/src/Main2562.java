import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main2562 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int count = 0;
		int max = 0;
		for (int i = 0; i < 9; i++) {
			int a = Integer.parseInt(br.readLine());
			if (max < a) {
				max = a;
				count = i;
			}
		}
		System.out.println(max);
		System.out.println(count+1);
	}
}
