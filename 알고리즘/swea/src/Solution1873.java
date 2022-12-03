import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution1873 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			bw.append("#" + tc + " ");

			st = new StringTokenizer(br.readLine());
			int H = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());
			char[][] arr = new char[H][W];

			// 나의 위치와 방향
			int x = 0;
			int y = 0;
			char direction = '0';

			// 배열채우기 열차가 어디있는지, 어디 방향인지 기억하기
			for (int i = 0; i < H; i++) {
				String str = br.readLine();
				for (int j = 0; j < W; j++) {
					if (str.charAt(j) == '>' || str.charAt(j) == '<' || str.charAt(j) == '^' || str.charAt(j) == 'v') {
						arr[i][j] = '.';
						x = i;
						y = j;
						direction = str.charAt(j);
					} else {
						arr[i][j] = str.charAt(j);
					}
				}
			}

			// 동작 수
			int N = Integer.parseInt(br.readLine());
			String typeStr = br.readLine();
			for (int n = 0; n < typeStr.length(); n++) {

				// 슈팅
				if (typeStr.charAt(n) == 'S') {
					if (direction == '^') {
						for (int j = 1; j <= x; j++) {
							if (arr[x - j][y] == '*' || arr[x - j][y] == '#') {
								if (arr[x - j][y] == '*') {
									arr[x - j][y] = '.';
								}
								break;
							}
						}
					} else if (direction == 'v') {
						for (int j = 1; j < H - x; j++) {
							if (arr[x + j][y] == '*' || arr[x + j][y] == '#') {
								if (arr[x + j][y] == '*') {
									arr[x + j][y] = '.';
								}
								break;
							}
						}
					} else if (direction == '<') {
						for (int j = 1; j <= y; j++) {
							if (arr[x][y - j] == '*' || arr[x][y - j] == '#') {
								if (arr[x][y - j] == '*') {
									arr[x][y - j] = '.';
								}
								break;
							}
						}
					} else if (direction == '>') {
						for (int j = 1; j < W - y; j++) {
							if (arr[x][y + j] == '*' || arr[x][y + j] == '#') {
								if (arr[x][y + j] == '*') {
									arr[x][y + j] = '.';
								}
								break;
							}
						}
					}
				}

				// 방향
				else if (typeStr.charAt(n) == 'U') {
					direction = '^';
					if (x - 1 >= 0 && arr[x - 1][y] == '.') {
						x -= 1;
					}
				} else if (typeStr.charAt(n) == 'D') {
					direction = 'v';
					if (x + 1 < H && arr[x + 1][y] == '.') {
						x += 1;
					}
				} else if (typeStr.charAt(n) == 'L') {
					direction = '<';
					if (y - 1 >= 0 && arr[x][y - 1] == '.') {
						y -= 1;
					}
				} else if (typeStr.charAt(n) == 'R') {
					direction = '>';
					if (y + 1 < W && arr[x][y + 1] == '.') {
						y += 1;
					}
				}
			}

			// 출력
			arr[x][y] = direction;
			for (char[] ch : arr) {
				for (char ch1 : ch) {
					bw.append(ch1);
				}
				bw.newLine();
			}

		} // tc
		bw.flush();
		br.close();
		bw.close();
	}
}
