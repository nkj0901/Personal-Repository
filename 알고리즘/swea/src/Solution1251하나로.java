import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Solution1251하나로 {
	static int N;
	static int[] x, y;
	static int[] p;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			
			x = new int[N];
			y = new int[N];
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				x[i] = Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				y[i] = Integer.parseInt(st.nextToken());
			}
			
			double E = Double.parseDouble(br.readLine());
			
			distance();
			
			//이제 정렬할 차례
			Arrays.sort(dist, new Comparator<double[]>() {
				@Override
				public int compare(double[] o1, double[] o2) {
					return Double.compare(o1[2], o2[2]);
				}
			});
			
			//대표를 저장할 배열
			p = new int[N];
			
			//make-set을 통해 자기 자신을 대표로 만들어 준다.
			for(int i = 0; i < N; i++) {
				p[i] = i;
			}
			
			int pick = 0;
			double ans = (long)0;
			//간선 선택하기
			for(int i = 0; i < N*(N-1); i++) {
				int px = findSet((int)dist[i][0]);
				int py = findSet((int)dist[i][1]);
				
				if(px != py) {
//					System.out.println(px + " " + py);
					union(px,py);
					ans = (double) (ans + Math.pow(dist[i][2],2)*E);
					pick++;
				}
				if(pick == N-1) break;
			}
			
			System.out.println("#" + t + " " + Math.round(ans));
		}
	}
	
	private static void union(int px, int py) {
		p[py] = p[px];
	}
	
	static double[][] dist;
	
	private static void distance() {
		dist = new double[N*(N-1)][3]; 
		double d = 0;
		int cnt = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				//i번째 정점과 나머지 정점 사이의 거리를 구하기
				//같으면 패스
				if(i == j) continue;
				
				//x와 y가 둘다 다르면 빗변의 길이를 구해야 됨
				if(x[i] != x[j] && y[i] != y[j]) {
					d = Math.sqrt(Math.pow(Math.abs(x[i]-x[j]), 2) + Math.pow(Math.abs(y[i]-y[j]), 2));
				} else {
					d = Math.abs(x[i]-x[j]) + Math.abs(y[i]-y[j]);
				}
				dist[cnt][0] = i;
				dist[cnt][1] = j;
				dist[cnt][2] = d;
				cnt++;
			}
		}
	}
	
	private static int findSet(int d) {
		if(d == p[d]) return d;
		else return findSet((int)p[d]);
	}
	
}
