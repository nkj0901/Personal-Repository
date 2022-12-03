import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution1226미로1 {
	public static void main(String[] args) throws IOException {
		
		class Node{
			int r;
			int c;
			
			Node(int r, int c){
			this.r = r;
			this.c = c;
			}
		}
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		for(int t = 1; t <= 10; t++) {
			
			int T = Integer.parseInt(br.readLine());
			
			int[][] maze = new int[16][16];
			boolean[][] visited = new boolean[16][16];
			
			//배열채우기
			for(int i = 0; i < 16; i++) {
				String str = br.readLine();
				for(int j = 0; j < 16; j++) {
					maze[i][j] = str.charAt(j)-'0';
				}
			}
			
			Queue<Node> queue = new LinkedList<>();
			Node node = new Node(1, 1); //시작점
			queue.add(node);
			int[] dr = {-1, 0, 1, 0};
			int[] dc = {0, 1, 0, -1};
			
			boolean flag = false;
			loop : while(!queue.isEmpty()) {
				Node n = queue.poll();
				
				//사방탐색을 하면서 방문하지 않았고 0인 부분을 찾는다.
				for(int i = 0; i < 4; i++) {
					int nr = n.r + dr[i];
					int nc = n.c + dc[i];
					//찾았으면 queue에 넣는다.
					if(maze[nr][nc] == 0 && visited[nr][nc] == false) {
						visited[nr][nc] = true;
						Node newNode = new Node(nr,nc);
						queue.add(newNode);
					}
					else if(maze[nr][nc] == 3) {
						flag = true;
						break loop;
					}
				}
			}
			int ans = flag==true ? 1 : 0;
			bw.write("#" + t + " " + ans + "\n");
			}
		bw.flush();
		br.close();
		bw.close();
	}
}
