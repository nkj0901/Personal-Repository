import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main2941 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String s = br.readLine();
		int c = 0;
		for (int i = 0; i < s.length(); i++) {
			c++;
			// =나 =가 나올 경우 카운트를 하지 않는다.
			if (s.charAt(i) == '=' || s.charAt(i) == '-') {
				c--;
			}
			// z가 나왔는데 앞이 d이고 뒤가 =이면 안 센다.
			else if (s.charAt(i) == 'd') {
				if (i + 2 < s.length() && s.charAt(i + 1) == 'z' && s.charAt(i + 2) == '=') {
					i++;
				}
			}
			// l이 나왔는데 뒤가 j일때
			else if (s.charAt(i) == 'l') {
				if (i + 1 < s.length() && s.charAt(i + 1) == 'j') {
					i++;
				}
			}
			// n가 나왔는데 뒤가 j일 때
			else if (s.charAt(i) == 'n') {
				if (i + 1 < s.length() && s.charAt(i + 1) == 'j') {
					i++;
				}
			}

		}
		bw.write(c + "");
		bw.flush();
		br.close();
		bw.close();
	}
}
