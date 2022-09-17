import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main2422 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); //맛 개수
		int M = Integer.parseInt(st.nextToken()); //안되는 조합 개수
		int cnt = 0;
		
		String[][] arr = new String[M][2]; //먹으면 안되는 조합
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 2; j++) {
				String str = String.valueOf(st.nextToken());
				arr[i][j] = str;
			}
		}
		
		int check = 0;
		//아이스크림을 3개 고르기(모든 경우의 수 고려)
		for (int i = 1; i <= N-2; i++) {
			for (int j = i+1; j <= N-1; j++) {
				for (int z = j+1; z <= N; z++) {
					String str = (i+"")+(j+"")+(z+""); //String으로 형변환 시킨 후 합쳐~~
					cnt++;
					//안되는 조합인지 확인
					for (int m = 0; m < M; m++) {
						check = 0;
						if (str.contains(arr[m][0])) {
							check++;
						}
						if (str.contains(arr[m][1])) {
							check++;
						}
						if (check == 2) {
							cnt--; //만약 안되는 조합이면 cnt 하나 빼
							break;
						}
					}
				}
			}
		}
		bw.write(cnt+"");
		bw.flush();
		br.close();
		bw.close();
	}
}
