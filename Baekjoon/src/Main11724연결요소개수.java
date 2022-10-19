import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main11724연결요소개수 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		p = new int[N+1];
		int[] count = new int[N+1];
		
		for(int i = 1; i <= N; i++) {
			p[i] = i;
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int S = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			
			union(S, E);
			System.out.println(Arrays.toString(p));
		}
		
		for(int i = 1; i <= N; i++) {
			count[p[i]]++;
		}
		System.out.println(Arrays.toString(count));
		
		int ans = 0;
		for(int i = 1; i <= N; i++) {
			if( count[i] > 0) ans++;
		}
		
		System.out.println(ans);
	}

	static int[] p;
	
	private static void union(int s, int e) {
		p[findset(e)] = findset(s);
		System.out.println(findset(e) + " " + findset(s));
		System.out.println(e + " " + s);
		
	}

	private static int findset(int s) {
		
		if(s == p[s]) return p[s];
		else return p[s] = findset(p[s]);
	}
}
