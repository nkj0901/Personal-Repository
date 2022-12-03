import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution1230암호문3_링크드리스트구현 {
	static BufferedWriter bw;

	//노드 클래스 만들기
	static class Node {
		int data;
		Node link;

		public Node(int data) {
			this.data = data;
		}
	}

	static Node front = null;
	static Node rear = null;
	static int size = 0;
	
	//맨뒤에 노드 추가
	public static void add(int n) {
		Node node = new Node(n);
		if (size == 0) {
			front = node;
			rear = node;
		} else {
			rear.link = node;
			rear = node;
		}
		size++;
	}

	//원하는 위치에 노드 추가(맨앞과 중간)
	public static void insert(int l, int[] arr) {
		if (l == 0) {
			Node tmpfront = front;
			Node node = new Node(arr[0]);
			front = node;
			size++;
			Node location = front;
			for (int i = 1; i < arr.length; i++) {
				Node node1 = new Node(arr[i]);
				location.link = node1;
				location = node1;
				size++;
			}
			location.link = tmpfront;
		} else {
			// 먼저 위치 찾기
			Node location = front;
			for (int i = 0; i < l - 1; i++) {
				location = location.link;
			}
			Node nextLocation = location.link;
			
			for (int i = 0; i < arr.length; i++) {
				Node node = new Node(arr[i]);
				location.link = node;
				location = node;
				size++;
			}
			location.link = nextLocation;
		}
	}
	
	//맨뒤에 추하는 한꺼번에 여러개
	public static void adds(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			add(arr[i]);
		}
	}
	
	//노드 앞부터 10개 출력
	public static void print() throws IOException {
		Node location = front;
		for (int i = 0; i < 10; i++) {
			bw.write(location.data+" ");
			location = location.link;
		}
	}
	
	//노드 삭제(맨앞일때, 중간일 때)
	public static void delete(int l, int n) {
		if (l==0) {
			Node location = front;
			for (int i = 0; i < n; i++) {
				 front=location.link;
			}
		} else {
			// 먼저 위치 찾기
			Node location = front;
			for (int i = 0; i < l - 1; i++) {
				location = location.link;
			}
			
			Node nextLocation = location;
			//n만큼 뒤에 있는 애랑 열결시키기
			for(int i = 0; i < n+1; i++) {
				nextLocation = nextLocation.link;
			}
			location.link = nextLocation;
		}
		size-=n;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));

		for (int t = 1; t <= 10; t++) {
			front = null;
			rear = null;
			size = 0;

			int N = Integer.parseInt(br.readLine());

			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				int n = Integer.parseInt(st.nextToken());
				add(n);
			}

			int M = Integer.parseInt(br.readLine());
			int location = 0;
			int num = 0;

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				String str = st.nextToken();

				if (str.equals("I")) {
					location = Integer.parseInt(st.nextToken());
					num = Integer.parseInt(st.nextToken());
					int[] arr = new int[num];
					//한꺼번에 여러숫자 처리해야 하니까 배열에 담아서 함수로 보내~
					for (int j = 0; j < num; j++) {
						arr[j] = Integer.parseInt(st.nextToken());
					}
					insert(location, arr);
				} else if (str.equals("D")) {
					location = Integer.parseInt(st.nextToken());
					num = Integer.parseInt(st.nextToken());
					delete(location, num);
				} else if (str.equals("A")) {
					num = Integer.parseInt(st.nextToken());
					int[] arr = new int[num];
					//한꺼번에 여러숫자 처리해야 하니까 배열에 담아서 함수로 보내~
					for (int j = 0; j < num; j++) {
						arr[j] = Integer.parseInt(st.nextToken());
					}
					adds(arr);
				}
			}
			bw.write("#" + t + " ");
			print();
			bw.newLine();
		}
		bw.flush();
		br.close();
		bw.close();
	}
}