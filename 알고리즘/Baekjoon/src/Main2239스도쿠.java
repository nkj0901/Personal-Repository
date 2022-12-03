import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main2239스도쿠 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		arr = new int[9][9];

		// 배열채우기
		for (int i = 0; i < 9; i++) {
			String str = br.readLine();
			for (int j = 0; j < 9; j++) {
				arr[i][j] = str.charAt(j)-'0';
			}
		}
		
		dfs(0);
		
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				bw.write(arr[i][j]+"");
			}
			bw.newLine();
		}
		
		bw.flush();
		br.close();
		bw.close();
	}
	
	static int[][] arr;
	static boolean flag;

	private static void dfs(int d) {
		
		if( d == 81 ) {
			flag = true;
			return;
		}
		
		int r = d/9;
		int c = d%9;
		
		if(arr[r][c] != 0) {
			dfs(d+1);
		} else {
			for(int i = 1; i < 10; i++) {
				if(!isValid(r,c,i)) continue;
				arr[r][c] = i;
				dfs(d+1);
				
				//한번 끝에 도달했으면 나머지를 볼 필요가 없다.
				if(flag == true) return;
				arr[r][c] = 0;
			}
		}
	}

	private static boolean isValid(int r, int c, int n) {
		
		for(int i = 0; i < 9; i++) {
			if(arr[i][c] == n || arr[r][i]==n) return false;
		}
		
		int tmpR = r/3*3;
		int tmpC = c-c%3;
		for(int i = tmpR; i < tmpR+3; i++) {
			for(int j = tmpC; j < tmpC+3; j++) {
				if(arr[i][j] == n) return false;
			}
		}
		
		return true;
	}
}
