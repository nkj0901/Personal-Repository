import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main17070파이프옮기기1 {
	static int[][] arr;
	static int N;
	static int status = 1; //가로는 1, 세로는 2, 대각선은 3
	static int cnt = 0;
	
	public static void move(int x, int y) {
		
		if (x == N && y == N) {
			cnt++;
			return ;
		}
		
		if (status == 1) {
			//옆으로 가기
			if (arr[x][y+1]!=1) { 
				status = 1;
				move(x, y+1);
			} 
			//대각선으로 가기
			if (arr[x][y+1] != 1 && arr[x+1][y] != 1 && arr[x+1][y+1] != 1) { 
				status = 3;
				move(x+1, y+1);
			}
		} else if (status == 2) {
			if (arr[x+1][y] != 1) {
				status = 2;
				move(x+1, y);
			}
			if (arr[x][y+1] != 1 && arr[x+1][y] != 1 && arr[x+1][y+1] != 1) { 
				status = 3;
				move(x+1, y+1);
			}
		} else if (status == 3) {
			if (arr[x][y+1] != 1) {
				status = 1;
				move(x, y+1);
			}
			if (arr[x+1][y] != 1) {
				status = 2;
				move(x+1, y);
			}
			if (arr[x][y+1] != 1 && arr[x+1][y] != 1 && arr[x+1][y+1] != 1) { 
				status = 3;
				move(x+1, y+1);
			}
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		
		//방공간 배열채우기
		arr = new int[N+2][N+2];
		
		//테두리 1로 채우기
		for(int i = 0; i < N+2; i++) {
			arr[0][i] = 1;
			arr[i][0] = 1;
			arr[N+1][i] = 1;
			arr[i][N+1] = 1;
		}
		
		//배열채우기
		for (int i = 1; i < N+1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j < N+1; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		move(1,2);
		bw.write(cnt+"");
		bw.flush();
		br.close();
		bw.close();
	}
}
