import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution1493 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		int[] arr = new int[2]; // 입력값 받을 배열
		int[] xarr = new int[2]; // x값 받을 배열
		int[] yarr = new int[2]; // x값 받을 배열

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			arr[0] = Integer.parseInt(st.nextToken());// p
			arr[1] = Integer.parseInt(st.nextToken());// q

			// p의 좌표 구하기
			for (int x = 0; x < 2; x++) {
				int sum = 0;
				for (int i = 1; i <= arr[x]; i++) {
					// 이 수가 몇번째 줄에 있는지 파악하고 i번째에 있다는 소리
					sum += i;
					if (sum >= arr[x]) {
						// 맨 오른쪽에 있는 수의  x좌표는 i
						// i줄의 맨 오른쪽에서 몇번째에 있는지 파악 이게 x좌표
						// 맨오른쪽에 있는 아이의 숫자는 sum 여기서 -1씩 하면서 몇번째에 있는지 확인
						for (int j = 0; j < i; j++) {
							if (arr[x] == (sum - j)) {
								xarr[x] = i - j;
							}
						}
						// y는 i번째줄에서 x-1만큼 아래로 간 것
						yarr[x] = i - (xarr[x] - 1);
						break;
					}
				}
			}
			
			//좌표더하기
			int newX = xarr[0]+xarr[1];
			int newY = yarr[0]+yarr[1];
			
			//(newX, nesY)에 해당하는 숫자 구하기
			// ex)(2,3)이라면 y는 x-1만큼 내려운 것 
			// 그니까 3에 x-1을 더하면 맨 왼쪽에 있는 숫자를 알 수 있음
			int leftNum = newY+(newX-1);
			int newSum = 0;
			int line = 0;
			for (int i = 1; i <= leftNum; i++) {
				newSum+=i;
				if(newSum >=i)
					line = i;
			}
			
			//line 맨 오른쪽에 있는 숫자를 구하기
			int rightNum = 0;
			for (int i = 1; i <= line; i++) {
				rightNum+=i;
			}
			//숫자는  맨 오른쪽 숫자에서 line - newX 뺀 것이 답
			int ans = rightNum - (line-newX);
			
			bw.append("#" +  " "+ans);
			bw.newLine();
		}
		bw.flush();
		br.close();
		bw.close();
	}
}
