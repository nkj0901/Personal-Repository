import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution1215 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		for (int t = 1; t <= 10; t++) {

			int N = Integer.parseInt(br.readLine());
			char[][] arr = new char[8][8];

			// 배열채우기
			for (int i = 0; i < 8; i++) {
				String str = br.readLine();
				for (int j = 0; j < 8; j++) {
					arr[i][j] = str.charAt(j);
				}
			}

			// 배열 순회하면서 회문 몇개 있는지 보기
			int cnt = 0; // 회문 개수
			for (int i = 0; i < 8; i++) {
				for (int j = 0; j < 8; j++) {
					boolean h = true;
					boolean v = true;

					// 앞과 뒤, 위 아래 비교
					for (int z = 0; z < N / 2; z++) {

						// 세로
						// 인덱스 넘어가지 않도록 설정
						if (i + z < 8 && (i + (N - 1)) - z < 8) {
							if (arr[i + z][j] != arr[(i + (N - 1)) - z][j]) {
								h = false; // 다르면 false
							}
						} else { 
							//범위 넘어가면 false
							h = false;
						}

						// 가로
						// 인덱스 넘어가지 않도록 설정
						if (j + z < 8 && (j + (N - 1)) - z < 8) {
							if (arr[i][j + z] != arr[i][(j + (N - 1)) - z]) {
								v = false; // 다르면 false
							}
						} else {
							//범위 넘어가면 false
							v = false;
						}
					}
					// 다 같아서 true로 통과했다면, cnt++
					if (h == true)
						cnt++;
					if (v == true)
						cnt++;
				}
			}
			bw.append("#" + t + " " + cnt + "\n");
		} // 테케
		bw.flush();
		br.close();
		bw.close();
	} // 메인
}
