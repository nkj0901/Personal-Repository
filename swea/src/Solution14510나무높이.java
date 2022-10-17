import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution14510나무높이 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			
			int N = Integer.parseInt(br.readLine());
			tree = new int[N];
			
			st = new StringTokenizer(br.readLine());
			max = Integer.MIN_VALUE;
			for(int i = 0; i < N; i++) {
				tree[i] = Integer.parseInt(st.nextToken());
				max = Math.max(max, tree[i]);
			}
			
			while(true) {
				check();
			}
		}

	}

	static int[] tree;
	static int max;
	
	private static boolean check() {
		
		for(int i = 0; i < tree.length; i++) {
			if(tree[i] != max)
				return false;
		}
		return true;
	}
}
