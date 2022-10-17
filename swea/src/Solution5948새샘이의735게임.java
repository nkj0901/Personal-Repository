
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution5948새샘이의735게임 {
	static int[] arr, sel;
	static boolean[] visited;
	static Set<Integer> set;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			
			arr = new int[7];
			sel = new int[3];
			visited = new boolean[7];
			set = new HashSet<>();
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < 7; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			comb(0,0);
			ArrayList<Integer> list = new ArrayList<>(set);
			Collections.sort(list);
			System.out.println("#" + t + " " + list.get(list.size()-5));
		}
	}

	private static void comb(int N, int sum) {
		if(N == 3) {
			set.add(sum);
			return;
		}
		
		for(int i = 0; i < 7; i++) {
			if(visited[i]) continue;
			
			visited[i] = true;
			sel[N] = arr[i];
			comb(N+1, sum+arr[i]);
			visited[i] = false;
		}
	}
}
