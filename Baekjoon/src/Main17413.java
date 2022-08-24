import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main17413 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Stack<Character> stack = new Stack<>();
		int size = 0;

		String str = br.readLine();

		for (int i = 0; i < str.length(); i++) {
			
			if(i-1 > 0 && str.charAt(i-1)=='<') i--;
			if (str.charAt(i) == '<') {
				bw.append('<');
				while (true) {
					bw.append(str.charAt(++i));

					if (str.charAt(i) == '>') {
						break;
					}
				}
			} else {
				while (true) {
					if (i == str.length() || str.charAt(i) == ' ' || str.charAt(i) == '<') {
						break;
					}else {
						stack.push(str.charAt(i++));
						size++;
					}
				}
				while (size != 0) {
					bw.append(stack.pop());
					size--;
				}
				if (i < str.length() && str.charAt(i) != '<')
					bw.append(' ');
			}
		}
		bw.flush();
		br.close();
		bw.close();
	}
}
