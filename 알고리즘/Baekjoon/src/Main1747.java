import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main1747 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		//소수 판별
		boolean[] arr = new boolean[1500001];
		arr[0] = true;
		arr[1] = true;
		for (int i = 2; i < 1500001; i++) {
			if (arr[i] != true) {
				for (int j = 2; i * j < 1500001; j++) {
						arr[i * j] = true;
				}
			}
		}
		int ans = N;
		//팰린드롬인지 판별
		while(true) {
			boolean same = true;
			//N이 1500000넘어가면 멈춰~
			if (N > 1500000) break;
			// 소수이면 팰린드롬인지 한번 봐봐
			if (arr[N] == false) {
				String str = String.valueOf(N);
				for (int i = 0; i < str.length()/2; i++) {
					//앞뒤 다르면 탈락
					if (str.charAt(i) != str.charAt(str.length()-1-i)) {
						same = false;
						break;
					}
				}
			}else { //소수 아니여도 탈락
				same = false;
			}
			if (same == true) { //만약 팰린드롬이 나타나면 정답 저장하고 멈춰
				ans = N;
				break;
			}
			N++;
		}
		bw.write(ans+"");
		bw.flush();
		br.close();
		bw.close();
	}
}
