

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main22233가희 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		Set<String> set = new HashSet<String>();
		
		for(int i = 0; i < N; i++) {
			set.add(br.readLine());
		}
		
		int cnt = set.size();
		
		for(int i = 0; i < M; i++) {
			st=new StringTokenizer(br.readLine(), ",");
			
			while(st.hasMoreElements()) {
				String str = st.nextToken();
				if(set.contains(str)) {
					set.remove(str);
					cnt--;
				}
			}
			bw.append(cnt+"\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
