import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main10819차이를최대로 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		sel = new int[N];
		check = new boolean[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		ans = 0;
		permutation(0);
		
		System.out.println(ans);
	}
	
	static int[] arr, sel;
	static boolean[] check;
	static int N, ans;
	
	private static void permutation(int n) {
		
		if (n == N) {
			int tmpAns = 0;
			for(int i = 0; i < N-1; i++) {
				tmpAns+=Math.abs(sel[i]-sel[i+1]); 
			}
			ans = Math.max(tmpAns, ans);
		}
		
		for(int i = 0; i < N; i++) {			
			if(check[i]) continue;
			check[i] = true;
			sel[n] = arr[i];
			permutation(n+1);
			check[i] = false;
		}
	}

}
