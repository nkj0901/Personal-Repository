import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main9205맥주마시면서걸어가기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());
			Node[] map = new Node[N+2];
			
			//일단 상근이네부터 편의점, 페스티벌의 거리를 다 입력받는다.
			for(int i = 0; i < N+2; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken()); 
				int y = Integer.parseInt(st.nextToken());
				map[i] = new Node(x, y, i);
			}
			
			// 인접리스트를 만든다.
			List<Node>[] adjList = new ArrayList[N+2]; //배열이니까 크기 지정 필요
			for(int i = 0; i < N+2; i++) {
				adjList[i] = new ArrayList<>();
			}
			
			//리스트에 1000m 내에 있는 아이들만 넣는다.
			for(int i = 0; i < N + 1; i++) { 
				for(int j = i+1 ; j < N+2; j++) {
					if((Math.abs(map[i].r-map[j].r)+Math.abs(map[i].c-map[j].c)) <= 1000) {
						adjList[i].add(map[j]); //양반향 연결이 되어있으니까 둘다 넣어주기~~
						adjList[j].add(map[i]);
					}
				}
			}
			
			//bfs 돌면서 페스트벌에 도착할 수 있는지 보자
			Queue<Node> queue = new LinkedList<>();
			boolean[] check = new boolean[N+1];
			//상근이네에서 1000m 이내에 있는 아이들을 넣어주자
			queue.addAll(adjList[0]);
			check[0] = true;
			
			boolean flag = false;
			while(!queue.isEmpty()) {
				Node n = queue.poll();
				
				if(n.r==map[N+1].r && n.c == map[N+1].c) { //페스티벌에 도달했으면 멈춰
					flag = true; break;
				}
				
				if(check[n.num]) continue;
				check[n.num] = true;
				
				queue.addAll(adjList[n.num]);
			}
			
			String ans = flag == true ? "happy" : "sad";
			System.out.println(ans);
		}
	}
	
	static class Node {
		int r, c, num;
		Node(int r, int c, int num){
			this.r = r;
			this.c = c;
			this.num = num; //몇번 노드인지 알려주는 아이
		}
	}
}
