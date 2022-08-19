import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Main2999 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// 문장의 길이의 로 배열 만들기
		String str = br.readLine();
		List<Integer> list = new ArrayList<Integer>();
		// 약수구하기
		for (int i = 1; i <= str.length(); i++) {
			if (str.length() % i == 0) {
				list.add(i);
			}
		}
		int x;
		int R;// 배열의 행
		int C;// 배열의 열
		// 리스트가 짝수이면 /2 한 값 전이 R
		if (list.size() % 2 == 0) {
			x = (list.size() / 2) - 1;
			R = list.get(x);
			C = list.get(list.size() - 1 - x);
		}
		// 홀수이면 가운데 숫자만 가지고 배열을 만들 것.
		else {
			x = (list.size() / 2);
			R = list.get(x);
			C = list.get(x);
		}
		int z = 0;
		char[][] arr = new char[R][C];
		for (int i = 0; i < C; i++) {
			for (int j = 0; j < R; j++) {
				 arr[j][i]=str.charAt(z++);
			}
		}
		for (int i = 0; i < R ; i++) {
			for (int j = 0; j < C; j++) {
				bw.write(arr[i][j]+"");
				 
			}
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
