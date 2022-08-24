import java.io.IOException;
import java.util.Scanner;

public class Solution1225_1 {

	static class Node {
		int data;
		Node link;

		public Node(int data) {
			this.data = data;
			this.link = null;
		}
	}

	static class LinkedQueue {
		static Node front;
		static Node rear;
		static int size;

		// isEmpty
		public static boolean isEmpty() {
			return size == 0;
		}

		// enQueue
		public static void enQueue(int data) {
			Node node = new Node(data);
			if (size == 0) {
				front = node;
				rear = node;
			} else {
				rear.link = node;
				rear = node;
			}
			size++;
		}

		// deQueue
		public static void deQueue() {
			if (size == 0) {
				System.out.println("출력할 데이터가 없습니다.");
			} else {
				if (size > 1) {
					front = front.link;
				}
				size--;
			}
		}

		// printQueue
		public static void printQueue() {
			if (isEmpty()) {
				System.out.println("출력할 데이터가 없습니다.");
			} else {
				for (int i = 0; i < 8; i++) {
					System.out.print(front.data + " ");
					if (front.link != null) {
						front = front.link;
					}
				}
			}
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		
		for (int t = 1; t <= 10; t++) {
			LinkedQueue.front = null;
			LinkedQueue.rear = null;
			LinkedQueue.size = 0;

			int T = sc.nextInt();

			// 링크드 큐에 집어넣기
			for (int i = 0; i < 8; i++) {
				int x = sc.nextInt();
				LinkedQueue.enQueue(x);
			}

			// 하나씩 디큐한다음 -하고 뒤로 다시 붙여넣기
			boolean stop = true;
			while (stop) {
				for (int i = 1; i <= 5; i++) {
					int x = LinkedQueue.front.data;
					LinkedQueue.deQueue();
					LinkedQueue.enQueue(x - i);
					if (x-i <= 0) {
						stop = false;
						break;
					}
				}
			}
			LinkedQueue.rear.data = 0;
			System.out.print("#" + T + " ");
			LinkedQueue.printQueue();
			System.out.println();
		}
	}
}
