import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution1218 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//왼쪽 괄호를 관리할 스택 생성
		Stack stack = new Stack();
		//pop했던 걸 임시로 담을  list
		List<Character> arr = new ArrayList<>();

		//테스트 케이스 10번 반복
		for (int t = 1; t <= 10; t++) {
			// 사이즈, 스택, 리스트 모든 초기화
			int size = 0;
			stack.clear();
			
			//입력값 받기
			int N = Integer.parseInt(br.readLine());
			String str = br.readLine();

			// 문자열 하나하나 탐색
			loop : for (int i = 0; i < str.length(); i++) {
				arr.clear();
				char x = str.charAt(i);
				char y = '(';
				
				// 왼쪽 괄호이면 stack에 넣는다.
				if (x == '(' || x == '[' || x == '{' || x == '<') {
					stack.push(x);
					size++;
				}
				// 오른쪽괄호이면 stack에 왼쪽 괄호가 있는지 찾는다. 있으면 없애버린다. 꺼낸것들을 다시 순서대로 집어넣는다.
				else {
					// 탐색하기
					// 사이즈가 영일 때 사이즈 1로 끝내버리기
					if (size == 0) {
						size++;
						break;
					} 
					else if (size > 0) {
						if (x == ')') 
							y = '(';
						else if (x == ']')
							y = '[';
						else if (x == '}')
							y = '{';
						else y = '<';
							
							for (int j = 0; j < size; j++) {
								char tmp = (char) stack.pop();
								// 만약 '('가 아니면 팝해서 없애고 나중에 다시 집어넣음
								if (tmp == y) {
									size--;
									break;
								} else {
									arr.add(tmp);
									//끝까지 없을 경우는 사이즈 1로 끝내버리기
									if (j == size -1) {
										size = 1;
										break loop;
									}
								}
							}
						for (int j = 0; j < arr.size(); j++) {
							stack.add(arr.get(j));
						}
					}
				}
			}
			System.out.print("#" + t + " ");
			if (size == 0) {
				System.out.println("1");
			} else if (size > 0) {
				System.out.println("0");
			}
		}
	}
}
