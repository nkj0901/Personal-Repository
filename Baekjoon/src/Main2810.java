import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main2810 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		String seat = br.readLine();
		char[] seatArray = seat.toCharArray();
		
		int cupHolder = 1; //왼쪽 끝에 기본적으로 있는 것
		for (int i = 0; i < N; i++) {
			if (seatArray[i]=='S') {
				cupHolder++;
			} else if (seatArray[i]=='L') {
				cupHolder++;
				i++; //L이 연속적으로 나올 것이므로 패스하고 컵홀더도 두좌석에 하나만 ++
			}
		}
		int ans = 0;
		//컵홀더가 좌석보다 많으면 좌석 수를 출력, 컵홀터가 더 적으면 컵홀더 수를 출력
		if (cupHolder > seatArray.length) {
			ans = seatArray.length;
		} else {
			ans = cupHolder;
		}
		bw.write(ans+"");
		bw.flush();
		br.close();
		bw.close();
	}
}
