import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution1974 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {

			int[][] arr = new int[9][9];
			Set<Integer> set = new HashSet<>();
			boolean nine = true;

			// 배열 채우면서 가로로 숫자가 9개 잘 있는지 확인
			for (int i = 0; i < 9; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 9; j++) {
					int x = Integer.parseInt(st.nextToken());
					arr[i][j] = x;
					set.add(x);
				}
				if (set.size() != 9) {
					nine = false;
					break;
				}
				set.clear();
			}

			// 세로 확인
			if (nine == true) {
				for (int i = 0; i < 9; i++) {
					for (int j = 0; j < 9; j++) {
						set.add(arr[j][i]);
					}
					if (set.size() != 9) {
						nine = false;
						break;
					}
					set.clear();
				}
			}

			// 네모칸 확인
			if (nine == true) {
				loop : for (int i = 0; i < 9; i += 3) {
					for (int j = 0; j < 9; j += 3) {
						
						for (int x = 0; x < 3; x++) {
							for (int y = 0; y < 3; y++) {
								set.add(arr[i+x][j+y]);
							}
						}
						if (set.size() != 9) {
							nine = false;
							break loop;
						}
						set.clear();
					}
				}
			}
			bw.append("#" + tc + " ");
			if (nine == true)
			bw.append("1");
			else bw.append("0");
			bw.newLine();
		}
		bw.flush();
		br.close();
		bw.close();
	}
}
