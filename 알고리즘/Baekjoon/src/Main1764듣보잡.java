import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

//처음에 set이 아니라 ArrayList를 썼음 
//set의 contains는 O(1) ArrayList의 contains는 O(n)이다.

public class Main1764듣보잡 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		Set<String> set = new HashSet<>();
		List<String> ans = new ArrayList<>();
		
		for(int i = 0; i < N; i++) {
			set.add(br.readLine());
		}

		for(int i = 0; i < M; i++) {
			String str = br.readLine();
			if(set.contains(str)) {
				ans.add(str);
			}
		}
		
		Collections.sort(ans);
		System.out.println(ans.size());
		for(int i = 0; i < ans.size(); i++) {
			System.out.println(ans.get(i));
		}
	}
}
