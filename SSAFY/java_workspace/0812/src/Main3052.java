import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;

public class Main3052 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		 //set 이용하기
		
		//set 배열만듥
		Set<Integer> arr = new HashSet<>();
		for (int i = 0; i < 10; i++) {
			int n = Integer.parseInt(br.readLine());
			int d = n%42;
			arr.add(d);
		}
		
		int ans = arr.size();
		bw.write(ans + "");
		bw.flush();
		br.close();
		bw.close();
	}
}
