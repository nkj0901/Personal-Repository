import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution1940 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		//테스트케이스
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			
			//command 개수
			int N = Integer.parseInt(br.readLine());
			int speed = 0; //현재 속도 
			int ans = 0; //이동 거리
			for (int i = 0; i < N; i++) {
				
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				
				int b = 0;
				if (a != 0) { //영일 때는 이 값을 안 받음
				b = Integer.parseInt(st.nextToken());
				}
				
				//각각 command 수행
				if (a == 1) { //가속
					speed+=b;
					ans+=speed;
				} else if (a == 2) { //감속
					speed-=b;
					if (speed < 0) {
						speed = 0;
					}
					ans+=speed;
				} else {
					ans+=speed;
				}
			}
			bw.append("#"+ tc + " " + ans);
			bw.newLine();
		}
		bw.flush();
		br.close();
		bw.close();
	}
}
