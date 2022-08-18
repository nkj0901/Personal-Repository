import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main2477 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// 1제곱당 열리는 참외 개수
		int K = Integer.parseInt(br.readLine());
		int[] dir = new int[6];
		int[] s = new int[6];
		
		//방향과 길이를 받고 배열에 넣는다.
		for (int i = 0; i < 6; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int direction = Integer.parseInt(st.nextToken());
			int side = Integer.parseInt(st.nextToken());
			
			dir[i] = direction;
			s[i] = side;
		}
		
		// 3-> 2 or 1 -> 3 or 4 -> 1 or 2 -> 4일 때 마이너스
		int m = 0; //큰 사각형에서 마이너스해야 할 값
		for(int i =0; i < dir.length-1; i++) {
			int t = dir[i];
			int t1 = dir[i+1];
			if (t==3&&t1==2 || t==1&&t1==3 || t==4&&t1==1 || t==2&&t1==4) {
				m=s[i]*s[i+1];
			}
		}
		// 큰 사격형의 크기를 구한다.
		int width = 0;
		int heigh = 0;
		for (int i = 0; i < dir.length; i++) {
			if (dir[i]==4) {
				width+=s[i];
			}
			if (dir[i]==1) {
				heigh+=s[i];
			}
		}
		int square = width*heigh;
		int extend = square-m;
		
		int ans = extend*K;
		
		bw.write(ans+"");
		bw.flush();
		bw.close();
		br.close();
	}
}
