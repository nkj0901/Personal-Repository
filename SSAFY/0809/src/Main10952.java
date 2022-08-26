import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main10952 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
		for(int i = 0; i < 100; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()); // 문자열로 인자 받기
			int A = Integer.parseInt(st.nextToken()); // 첫번째 호출을 to int
			int B = Integer.parseInt(st.nextToken());
			bw.write(A + B + "");
			bw.newLine();
		}
			bw.flush();
			br.close();
			bw.close();
		}
	}
