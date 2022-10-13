package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution2382미생물격리 {
	
	static class Node{
		int r, c, num, dir;
		
		Node(int r, int c, int num, int dir){
			this.r = r;
			this.c = c;
			this.num = num;
			this.dir = dir;
		}
	}
	
 public static void main(String[] args) throws NumberFormatException, IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st;
	
	int T = Integer.parseInt(br.readLine());
	
	for(int t = 1; t <= T; t++) {
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		//배열초기화
		List<Node>[][] list = new ArrayList[N][N];
		
		for(int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				list[i][j] = new ArrayList<>();
			}
		}
		
		for(int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());
			int dir = Integer.parseInt(st.nextToken());
			
			list[r][c].add(new Node(r, c, num, dir));
		}
		
		
		for(int m = 0; m < M; m++) {
			List<Node> tmp = new ArrayList<>();
			//순회하면서 다 옮겨준다
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
//					System.out.println(i + " " + j);
					if (list[i][j].size()>0) {
						
						//꺼내고 바로 지워줘
						Node n = list[i][j].get(0);
						list[i][j].remove(0);
						
						//다음에 넣어줘
						int newI = 0;
						int newJ = 0;
						if(n.dir==1) {
							newI = i-1;
							newJ = j;
						}
						else if(n.dir==2) {
							newI = i+1;
							newJ = j;
						}
						else if(n.dir==3) {
							newI = i;
							newJ = j-1;
						}
						else {
							newI = i;
							newJ = j+1;
						}
						
						//근데 간 곳이 맨끝이야? 그럼 수 반으로 줄이고 방향 바꿔줘
						if(newI == 0 || newJ == 0 || newI == N-1 || newJ == N-1) {
							n.num = n.num/2;
							
							if(n.dir == 1) n.dir = 2;
							else if(n.dir == 2) n.dir = 1;
							else if(n.dir == 3) n.dir = 4;
							else n.dir = 3;
						}
						
						tmp.add(new Node(newI, newJ, n.num, n.dir));
					}
				}
			}
			
			for(int a = 0; a < tmp.size(); a++) {
				Node n = tmp.get(a);
				list[n.r][n.c].add(n);
			}
			
			//한칸에 두개이상의 군집이 있나 봐봐
			for(int a = 0; a < N; a++) {
				for(int b = 0; b < N; b++) {
					
					//있으면 합쳐줘
					if(list[a][b].size() > 1) {
						
						int max = 0;
						int maxDir = 0;
						int cnt = 0;
						
						for(int c = list[a][b].size()-1; c >= 0 ; c--) {
							
							Node node = list[a][b].get(c);
							list[a][b].remove(c);
							
							cnt+=node.num;
							
							if (node.num > max) {
								max = node.num;
								maxDir = node.dir;
							}
						}
						list[a][b].add(new Node(a, b, cnt, maxDir));
					}
				}
			}
		}// M
		
		//이제 몇마리 남았나 보자
		int ans = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				
				if(list[i][j].size() > 0) {
					ans+=list[i][j].get(0).num;
				}
				
			}
		}
		System.out.println("#" + t + " " + ans);
	}//tc
	
}
}
