import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main2621 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int ans = 0;

		int[] number = new int[10];

		// 일단 카트 한 장 받아서 무슨 색인지 알아보고 숫자는 카운트배열로~
		st = new StringTokenizer(br.readLine());
		String color = st.nextToken();
		int N = Integer.parseInt(st.nextToken());
		number[N]++;

		// 나머지 4장의 색이 같으면 ccnt++
		int ccnt = 1;
		int maxIndex = N; // 제일 큰 숫자 저장
		for (int i = 0; i < 4; i++) {
			st = new StringTokenizer(br.readLine());
			String c = st.nextToken();
			int num = Integer.parseInt(st.nextToken());
			if (color.equals(c)) {
				ccnt++;
			}
			number[num]++;
			if (maxIndex < num) {
				maxIndex = num;
			}
		}

		// 숫자가 연속적으로 있는지 보기
		int serialcnt = 0;
		int serialIndex = 0; // 제일 큰 수
		for (int i = 1; i < 10; i++) {
			if (number[i] == 1) {
				serialcnt++;
				if (serialcnt == 5) {
					serialIndex = i;
					break;
				}
			} else {
				serialcnt = 0;
			}
		}

		// 첫번째 많은 수와 두번째 많은 수 찾기(몇개, 숫자 뭔지 찾기)
		// 첫번째 많은 수 찾자
		int first = 0;
		int firstIndex = 0;
		for (int i = 1; i < 10; i++) {
			if (first < number[i]) {
				first = number[i];
				firstIndex = i;
			}
		}

		// 두번째로 많은 애 찾아야 하니까 첫번재로 많은 애 비워
		number[firstIndex] = 0;
		int second = 0;
		int secondIndex = 0;
		for (int i = 1; i < 10; i++) {
			if (second < number[i]) {
				second = number[i];
				secondIndex = i;
			}
		}

		// 만약 색이 같고 연속적인 숫자가 있다면
		if (ccnt == 5 && serialcnt == 5) {
			ans = serialIndex + 900;
		}
		// 만약 같은 숫자가 4개이면
		else if (first == 4) {
			ans = firstIndex + 800;
		}
		// 만약 같은 숫자가 3개,2개씩이면
		else if (first == 3 && second == 2) {
			ans = firstIndex * 10 + secondIndex + 700;
		}
		// 5장이 같은 색이면
		else if (ccnt == 5) {
			ans = maxIndex + 600;
		}
		// 숫자가 연속적일 때
		else if (serialcnt == 5) {
			ans = serialIndex + 500;
		}
		// 같은 수가 3장이면
		else if (first == 3) {
			ans = firstIndex + 400;
		}
		//같은 수 2장씩
		else if (first == 2 && second == 2) {
			ans = Math.max(firstIndex, secondIndex)*10+Math.min(firstIndex,  secondIndex)+300;
		}
		//2장 같은 수
		else if (first == 2) {
			ans = firstIndex +200;
		}
		//어떤 경우에도 해당하지 않는다면
		else {
			ans = maxIndex+100;
		}
		bw.write(ans+"");
		bw.flush();
		br.close();
		bw.close();
	}
}
