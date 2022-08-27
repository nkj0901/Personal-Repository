import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution6485 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			bw.append("#" + t + " ");
			
			// 카운팅 배열 만들기
			int[] arr = new int[5001];

			int N = Integer.parseInt(br.readLine());
			
			for (int n = 0; n < N; n++) {
				st = new StringTokenizer(br.readLine());
				int A = Integer.parseInt(st.nextToken());
				int B = Integer.parseInt(st.nextToken());
				
				// 숫자 카운팅(어느정류장에 버스가 몇개 오는지)
				for (int i = A; i <= B; i++) {
					arr[i]++;
				}
			}
			
			int P = Integer.parseInt(br.readLine());
			
			//출력
			for (int i = 0; i < P; i++) {
				int index = Integer.parseInt(br.readLine());
				bw.append(arr[index]+" ");
			}
			bw.newLine();
			
		} //테케 끝
		bw.flush();
		br.close();
		bw.close();
	} //메인
}
