import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution5356 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			bw.append("#" + t + " ");
			char[][] arr = new char[5][15];

			// 배열채우면서 제일 긴 문자열 찾기
			int max = 0;
			for (int i = 0; i < 5; i++) {
				String str = br.readLine();
				if (str.length() > max) {
					max = str.length();
				}
				for (int j = 0; j < str.length(); j++) {
					arr[i][j] = str.charAt(j);
				}
			}

			// 세로로 읽기
			for (int i = 0; i < max; i++) {
				for (int j = 0; j < 5; j++) {
					if(arr[j][i] != '\u0000')
					bw.append(arr[j][i]);
				}
			}
			bw.newLine();
		}
		bw.flush();
		br.close();
		bw.close();
	}	
}
