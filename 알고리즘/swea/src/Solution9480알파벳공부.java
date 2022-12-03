import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Solution9480알파벳공부 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			
			N = Integer.parseInt(br.readLine());
			arr = new String[N];
			sel = new String[N];
			set = new HashSet<>();
			
			for(int i = 0; i < N; i++) {
				arr[i]= br.readLine();
			}
			
			cnt = 0;
			dfs(0);
			System.out.println("#" + t + " " + cnt);
		}
	}
	private static void dfs(int idx) {
		
		if(idx == N) {
			
			set.clear();
			for(int i = 0; i < N; i++) {
				char[] c = sel[i].toCharArray();
				
				for(int j = 0; j < c.length; j++) {
					set.add(c[j]);
				}
			}
			if(set.size() == 26) cnt++;
			return;
		}
		
		sel[idx] = arr[idx];
		dfs(idx+1);
		sel[idx] = "";
		dfs(idx+1);
		
	}
	
	static int N , cnt;
	static String[] arr;
	static String[] sel;
	static Set<Character> set;
}
