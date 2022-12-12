import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main5052전화번호목록 {
	
	//루트노드
	static Node rootNode;
	//다른 문자를 접두어로 가지고 있다면 체크
	static boolean prefix;
	
	//노드를 만들어주자
	static class Node{
		//자식노드들을 저장할 맵
		Map<Character, Node> childNode = new HashMap<>();
		//내가 마지막 아이이면 체크
		Boolean last = false;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//testcase 개수
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());
			
			rootNode = new Node();
			prefix = false;
			String ans = "";
			String[] word = new String[N];
			
			for(int i = 0; i < N; i++) {
				word[i] = br.readLine();
			}
			
			//내가 푼 방식으로 문제를 해결할 때에는
			//짧은 애부터 확인해야 접두어가 있는지 확인하기 쉽다.
			Arrays.sort(word);
			
			for(int i = 0; i < N; i++) {
				//단어 트리에 입력!
				insert(word[i]);
				
			}
			//다른 애를 접두어로 가지고 있대. 답은 no야
			if(prefix == true) {
				ans = "NO";
			} else {
				ans = "YES";
			}
			System.out.println(ans);
		}
	}

	private static void insert(String tmp) {
		//루트노드 가져오기
		Node node = rootNode;
		
		//node의 node배열(childNode)에 tmp.charAt(i)를 키값으로 가진 애가 존재 한다면 자식노드 반환.
		//없다면 새로운 Node를 만들어서 childNode에 tmp.charAt(i) = new Node() 넣어주고 new Node반환.
		for(int i = 0; i < tmp.length(); i++) {
			node = node.childNode.computeIfAbsent(tmp.charAt(i), key -> new Node());
			//근데 얘가 마지막 얘야? 그럼 접두어를 가지고 있다는 거니까 true 체크
			if(node.last == true) {
				prefix = true;
				return;
			}
		}
		//마지막 애는 마지막 애라고 표시해주기
		node.last=true;
	}
}
