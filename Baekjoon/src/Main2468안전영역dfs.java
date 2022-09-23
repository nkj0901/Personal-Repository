import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main2468안전영역dfs {
	static int N;
	static int[][] map;
	static int[][] visited;
	static int cnt;
	static int[] dr = { 0, -1, 0, 1 };
	static int[] dc = { -1, 0, 1, 0 };
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		
		// 배열채우기
		int max = 0;
		int ans = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				max = Math.max(max, map[i][j]);
			}
		}
		
		//최대 높이 -1한 값부터 돌려가면서 섬이 몇개씩 나오는지 확인해보기
		for (int d = max-1; d>=0; d--) {
			cnt = 0;
			
			//방문했던 곳은 다시 세면 안되니까 체크 배열을 만들어준다.
			//깊이마다 배열 새로 만들어줌
			visited = new int[N][N];
			
			//큰 높이부터 돌아가면서 안전지대 세보기
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				//물의 높이 보다 높고 방문하지 않은 곳만 체크
				if (map[i][j] > d && visited[i][j] == 0) {
					cnt++;
					dfs(i, j, d);
				}
			}
		}
		ans = Math.max(cnt, ans);
		}
		bw.write(ans+"\n");
		bw.flush();
		br.close();
		bw.close();
	}
	static void dfs(int r, int c, int deep) {
		//여기 방문했다는 것을 표시
		visited[r][c] = 1;
		
		//사방탐색, 사방에  물높이보다 높은 곳이 있으면 세면 안됨
		for (int i = 0; i < 4; i++) {
			int nr = r+dr[i];
			int nc = c+dc[i];
			
			if (nr>=0 && nr<N && nc>=0 && nc<N) {
				if(map[nr][nc] > deep && visited[nr][nc] == 0) {
					//사방탐색하면서 물보다 높고 방문한 적이 없는 곳이면 거기로 옮겨 가서 더 있나 찾아보기
					dfs(nr, nc, deep);
				}
			}
		}
	}
}
