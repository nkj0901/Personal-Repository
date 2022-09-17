import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main18511_오답 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		String N = st.nextToken();
		int K = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[K];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < K; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		//N의 첫 숫자와  ARR돌려가며 숫자 크기 비교
		//만약 ARR[J] 숫자가 N보다 작을 때,뒤에꺼는 비교할 필요없이 뒤에는 제일 큰 수 출력해버림 된다.
		//숫자가 같으면 다음 숫자 비교해야 된다.
		//다음 숫자 비교해야 되는지 아니면 그냥 출력해도 되는지 알려주는 것
		boolean keepGoing = true; 
		int cnt = 0; //새로만든 숫자열 길이 비교
		
		for (int i = 0; i < N.length(); i++) {
			int charIndex = N.charAt(i)-'0';
			for (int j = K-1; j >= 0; j--) {
				if (keepGoing == true) {
					if (charIndex > arr[j]) {
						keepGoing = false;
						bw.write(arr[j]+"");
						break;
					} else if (charIndex == arr[j]) {
						bw.write(arr[j]+"");
						break;
					} else if (j == 0) {
						cnt++;
						if (cnt >= 2) {
							keepGoing = false;
							bw.write(arr[K-1]+"");
							break;
						}
					}
				} else {
					bw.write(arr[K-1]+"");
					break;
				}
			}
		}
		bw.flush();
		br.close();
		bw.close();
	}
}
