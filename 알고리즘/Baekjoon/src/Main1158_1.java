import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main1158_1 { // 링크드큐 이용해보기
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		Queue<Integer> list = new LinkedList<>();

		// 배열에 숫자 채워넣기
		int size = 0;
		for (int i = 1; i <= N; i++) {
			list.add(i);
			size++;
		}
		sb.append("<");
		int cnt = 0;
		while (true) {
			cnt++;
			if (cnt == K) {
				sb.append(list.remove() + ", ");
				size--;
				cnt = 0;
				if(list.isEmpty()) 
					break;
			} else {
				list.add(list.remove());
			}
		}
		
		sb.delete(sb.length()-2, sb.length()).append(">");
		System.out.println(sb);
		br.close();
	}
}
